package main.language;

import main.language.functions.PrimitiveFunction;
import main.language.mem.Memory;
import main.language.nodes.*;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.nodes.special_operators.ReturnNode;
import main.language.nodes.statements.AssignmentNode;
import main.language.nodes.statements.ConditionBlockNode;
import main.language.nodes.statements.StatementNode;
import main.language.nodes.statements.WhileNode;
import main.language.state.ReturnedState;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Runner {

    private List<Statementable> program;

    private Statementable visitStatement(LangParser.StatementContext ctx)
    {
        Statementable s;
        if (ctx.assign != null) {
            LangParser.AssignmentContext a = ctx.assign;
            s = new AssignmentNode(a.var != null ? new VariableNode(a.var) : new PointerNode(visitExpr(a.e)),
                    visitExpr(a.ex));
        }
        else
        if (ctx.func != null) {
            s = new StatementNode(visitFunctionCall(ctx.func));
        }
        else
        if (ctx.ifbl!= null) {
            s = visitConditionBlock(ctx.ifbl);
        }
        else
        if (ctx.whbl!= null) {
            s = visitWhileBlock(ctx.whbl);
            //s = visitWhile(ctx.whbl);
        }
        else
        {
            s = new ReturnNode(ctx.s_o.e == null? null: visitExpr(ctx.s_o.e));
        }
        return s;
    }
    private ExpressionNode visitExpr(LangParser.ExprContext ctx)
    {
        ExpressionNode left = visitAdd(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitAdd(ctx.right.get(i));
            String op = ctx.op.get(i).getText();
            switch (op) {
                case "+":
                    left = new FunctionNode(PrimitiveFunction.sum, Arrays.asList(left, right));
                    break;
                case "-":
                    left = new FunctionNode(PrimitiveFunction.sub, Arrays.asList(left, right));
                    break;
                default:
                    throw new RuntimeException("Unidentified symbol: " + ctx.op.get(i));
            }
        }
        return left;

    }
    private ExpressionNode visitMul(LangParser.MulContext ctx)
    {
        ExpressionNode node;
        if (ctx.fun!=null)
        {
            node = visitFunctionCall(ctx.fun);
        }
        else
        if (ctx.lit != null)
        {
            node = new LiteralNode(ctx.lit);
        }
        else
        if (ctx.var!= null)
        {
            node = new VariableNode(ctx.var, ctx.pointer != null);
        }
        else
        {
            node = visitExpr(ctx.expr());
        }
        if (ctx.op != null)
            node = new UnaryOperationNode(ctx.op, node);
        return node;
    }
    private FunctionNode visitFunctionCall(LangParser.Func_callContext f)
    {
        List<ExpressionNode> list = new ArrayList<>();
        if (f.e1 != null)
        {
            Stream<LangParser.ExprContext> s = Stream.of(f.e1);
            if (f.exs!= null)
                s = Stream.concat(s, f.exs.stream());
            list = s.map(this::visitExpr).collect(toList());
        }
        return new FunctionNode(Memory.getGlobalMemory().getFunction(f.n.getText()),
               list);
    }
    private ConditionBlockNode visitConditionBlock(LangParser.If_blockContext ctx)
    {
        return new ConditionBlockNode( visitCondition(ctx.cond), visitProgram(ctx.if_st),
                ctx.else_st == null? null: visitProgram(ctx.else_st));
    }
    private WhileNode visitWhileBlock(LangParser.While_blockContext ctx)
    {
        return new WhileNode(visitProgram(ctx.st), visitCondition(ctx.cond));
    }
    private ConditionNode visitCondition(LangParser.ConditionContext ctx)
    {
        return new ConditionNode(visitExpr(ctx.left), ctx.t, visitExpr(ctx.right));
    }
    private List<Statementable> visitProgram(List<LangParser.StatementContext> ctx)
    {
        return ctx.stream().map(this::visitStatement).collect(toList());
    }
    private void visitFunctionDeclaration(LangParser.FunctionContext function)
    {
        LangParser.VarsContext vars = function.v;
        List<VariableNode> list = new ArrayList<>();
        if (vars.var1 != null)
        {
            Stream<Token> s = Stream.of(vars.var1);
            if (vars.var!= null)
                s = Stream.concat(s, vars.var.stream());
            list = s.map(VariableNode::new).collect(toList());
        }
        Memory.getGlobalMemory().addFunction(new Function(
                visitProgram(function.st), list, function.name.getText()
        ));
    }
    private ExpressionNode visitAdd(LangParser.AddContext ctx)
    {
        ExpressionNode left = visitMul(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitMul(ctx.right.get(i));
            String op = ctx.op.get(i).getText();
            switch (op) {
                case "*":
                    left = new FunctionNode(PrimitiveFunction.mul, Arrays.asList(left, right));
                    break;
                case "/":
                    left = new FunctionNode(PrimitiveFunction.div, Arrays.asList(left, right));
                    break;
                case "%":
                    left = new FunctionNode(PrimitiveFunction.mod, Arrays.asList(left, right));
                    break;
                default:
                    throw new RuntimeException("Unidentified symbol: " + ctx.op.get(i));
            }
        }
        return left;
    }

    public static void run(String code)
    {
        new Runner(code);
    }
    private Runner(String code)
    {
        Memory.init();

        LangLexer lexer = new LangLexer(CharStreams.fromString(code));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ProgramContext context = p.program();
        context.st.forEach(st-> System.out.println(st.getText()));
        context.f.forEach(this::visitFunctionDeclaration);
        program = visitProgram(context.st);
        Stack<Memory> stack = new Stack<>();
        stack.push(Memory.getGlobalMemory());
        program.stream().map(s->s.execute(stack)).filter(state -> state.getClass() == ReturnedState.class).findFirst();
        Memory.destroy();
    }
}
