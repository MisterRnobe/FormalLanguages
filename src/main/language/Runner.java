package main.language;

import main.language.functions.Functions;
import main.language.functions.PrimitiveFunction;
import main.language.misc.VariablesPool;
import main.language.nodes.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    private static final VariablesPool variables =
            new VariablesPool();
    private static final List<Function> functions =
            new LinkedList<>();

    static void addFunction(Function f)
    {
        functions.add(f);// TODO: 01.12.2017 Edit
    }

    static Function getFunction(String name)
    {
        return functions.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }
    private static StatementNode visitStatement(LangParser.StatementContext ctx)
    {
        if (ctx.assign != null)
            return new StatementNode(visitAssignment(ctx.assignment()));
        else
        if (ctx.func != null)
            return new StatementNode(visitFunctionCall(ctx.func));
        else
        if (ctx.ifbl!= null)
            return visitCondition(ctx.ifbl);
        else
            return visitWhile(ctx.whbl);
    }
    private static AssignmentNode visitAssignment(LangParser.AssignmentContext ctx)
    {
        AssignmentNode n = new AssignmentNode(new VariableNode(ctx.var), ctx.op, visitExpr(ctx.ex));
        System.out.println(n);
        return n;
    }
    private static WhileNode visitWhile(LangParser.While_blockContext ctx)
    {

        return new WhileNode(visitCondition(ctx.cond), visitForList(ctx.st, Runner::visitStatement));
    }
    private static void initFunctions()
    {

        variables.clear();
        functions.clear();
        addFunction(Functions.sin);
        addFunction(Functions.print);
        addFunction(Functions.pow);
    }
    private static ConditionNode visitCondition(LangParser.ConditionContext ctx)
    {
        return new ConditionNode(visitExpr(ctx.left), ctx.t, visitExpr(ctx.right));
    }
    private static void visitFunctionDeclaration(LangParser.FunctionContext function)
    {
        List<StatementNode> body = function.st.stream().map(Runner::visitStatement).collect(Collectors.toList());
        List<Token> list = new ArrayList<>();
        list.add(function.v.var1);
        list.addAll(function.v.var);
        addFunction(new Function(body,list.stream().map(VariableNode::new).collect(Collectors.toList()),
                visitExpr(function.ret), function.name.getText()));
    }

    private static ExpressionNode visitExpr(LangParser.ExprContext ctx)
    {
        ExpressionNode left = visitAdd(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitAdd(ctx.right.get(i));
            String op = ctx.op.get(i).getText();
            if (op.equals("+"))
                left = new FunctionNode(PrimitiveFunction.sum, Arrays.asList(left, right));
            else
                if (op.equals("-"))
                    left = new FunctionNode(PrimitiveFunction.sub, Arrays.asList(left,right));
            else
                throw new RuntimeException("Unidentified symbol: "+ctx.op.get(i));
        }
        return left;

    }
    private static ExpressionNode visitMul(LangParser.MulContext ctx)
    {
        ExpressionNode node;
        if (ctx.fun!=null)
        {
            node = visitFunctionCall(ctx.fun);
        }
        else
        if (ctx.num != null)
        {
            node = new NumberNode(ctx.num);
        }
        else
        if (ctx.var!= null)
        {
            node = new VariableNode(ctx.var);
        }
        else
        {
            node = visitExpr(ctx.expr());
        }
        if (ctx.neg != null)
            node = new UnaryOperationNode(ctx.neg, node);
        return node;
    }
    private static FunctionNode visitFunctionCall(LangParser.Func_callContext f)
    {
        List<LangParser.ExprContext> list = new ArrayList<>();
        list.add(f.e1);
        list.addAll(f.exs);
        return new FunctionNode(getFunction(f.n.getText()),
                list.stream().map(Runner::visitExpr).collect(Collectors.toList()));
    }
    private static ExpressionNode visitAdd(LangParser.AddContext ctx)
    {
        ExpressionNode left = visitMul(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitMul(ctx.right.get(i));
            String op = ctx.op.get(i).getText();
            if (op.equals("*"))
                left = new FunctionNode(PrimitiveFunction.mul, Arrays.asList(left, right));
            else
            if (op.equals("/"))
                left = new FunctionNode(PrimitiveFunction.div, Arrays.asList(left,right));
            else
            if (op.equals("%"))
                left = new FunctionNode(PrimitiveFunction.mod, Arrays.asList(left,right));
            else
                throw new RuntimeException("Unidentified symbol: "+ctx.op.get(i));
        }
        return left;
    }
    private static ConditionBlockNode visitCondition(LangParser.If_blockContext context)
    {
        ConditionNode conditionNode = visitCondition(context.cond);
        System.out.println(context.else_st.size());
        List<StatementNode> elseBody = context.else_st == null? null: visitForList(context.else_st, Runner::visitStatement);
        return new ConditionBlockNode(conditionNode, visitForList(context.if_st, Runner::visitStatement), elseBody);
    }
    private static void compile(LangParser.StatementContext c)
    {
        visitStatement(c).execute(variables);
    }

    private static <T,E> List<E> visitForList(List<T> list, java.util.function.Function<T,E> function)
    {
        return list.stream().map(function).collect(Collectors.toList());
    }

    public static void run(String code)
    {
        LangLexer lexer = new LangLexer(CharStreams.fromString(code));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ProgramContext context = p.program();
        initFunctions();
        System.out.println(context.st.size());
        context.st.forEach(st-> System.out.println(st.getText()));
        context.f.forEach(Runner::visitFunctionDeclaration);
        context.st.forEach(Runner::compile);
    }
}
