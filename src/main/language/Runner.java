package main.language;

import main.language.functions.Functions;
import main.language.nodes.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    private static final MyMap variables =
            new MyMap();
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
    public static Double getVar(String var)
    {
        return variables.get(var);
    }
    private static StatementNode visitStatement(LangParser.StatementContext ctx)
    {
        if (ctx.assign != null)
            return new StatementNode(visitAssignment(ctx.assignment()));
        else
            return new StatementNode(visitFunc(ctx.func));

    }
    private static AssignmentNode visitAssignment(LangParser.AssignmentContext ctx)
    {
        AssignmentNode n = new AssignmentNode(new VariableNode(ctx.var), ctx.op, visitExpr(ctx.ex));
        System.out.println(n);
        return n;
    }
    private static void initFunctions()
    {
        addFunction(Functions.sin);
        addFunction(Functions.print);
        addFunction(Functions.pow);
    }
    private static void visitFunction(LangParser.FunctionContext function)
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
            left = new BinaryOperationNode(left, ctx.op.get(i), right);
        }
        return left;

    }
    private static ExpressionNode visitMul(LangParser.MulContext ctx)
    {
        ExpressionNode node;
        if (ctx.fun!=null)
        {
            node = visitFunc(ctx.fun);
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
    private static FunctionNode visitFunc(LangParser.Func_callContext f)
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
            left = new BinaryOperationNode(left, ctx.op.get(i), right);
        }
        return left;
    }
    private static void compile(LangParser.StatementContext c)
    {
        visitStatement(c).compute(variables);
    }

    public static void run(String code)
    {
        LangLexer lexer = new LangLexer(CharStreams.fromString(code));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ProgramContext context = p.program();
        initFunctions();
        context.f.forEach(Runner::visitFunction);
        context.st.forEach(Runner::compile);
        variables.clear();
        functions.clear();
    }
    public static void main(String[] args) {
        String test = "func cde(x): return x+1;"+
                "func sum(a,b): return a+b;"+
                "print(1,2); x := cde(12); y := sum(x,x); x:=2*x-y+1;";
        LangLexer lexer = new LangLexer(CharStreams.fromString(test));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ProgramContext context = p.program();
        System.out.println(context.st.size());
        context.f.forEach(Runner::visitFunction);
        context.st.forEach(Runner::compile);
        variables.forEach((k,v)->System.out.println(k+" = "+v));


    }
    public static class MyMap extends TreeMap<String, Double>
    {
        public void update(String var, Double val)
        {
            if (this.containsKey(var))
                this.replace(var, val);
            else
                this.put(var, val);
        }
    }
}
