package main.language;

import main.language.nodes.*;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CharStreamState;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class Runner {
    private static final Map<String, Double> variables =
            new TreeMap<>();
    public static void insert(String var, Double val)
    {
        if (variables.containsKey(var))
            variables.replace(var, val);
        else
            variables.put(var, val);
    }
    public static Double get(String var)
    {
        return variables.get(var);
    }
    public static StatementNode visitStatement(LangParser.StatementContext ctx)
    {
        return new StatementNode(visitAssignment(ctx.assignment()));
    }
    public static AssignmentNode visitAssignment(LangParser.AssignmentContext ctx)
    {
        return new AssignmentNode(new VariableNode(ctx.var), ctx.op, visitExpr(ctx.ex));
    }

    public static ExpressionNode visitExpr(LangParser.ExprContext ctx)
    {
        ExpressionNode left = visitAdd(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitAdd(ctx.right.get(i));
            left = new BinaryOperationNode(left, ctx.op.get(i), right);
        }
        return left;

    }
    public static ExpressionNode visitMul(LangParser.MulContext ctx)
    {
        ExpressionNode node;
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
    public static ExpressionNode visitAdd(LangParser.AddContext ctx)
    {
        ExpressionNode left = visitMul(ctx.left);
        for (int i = 0; i < ctx.op.size(); i++) {
            ExpressionNode right = visitMul(ctx.right.get(i));
            left = new BinaryOperationNode(left, ctx.op.get(i), right);
        }
        return left;
    }
    public static void compile(LangParser.StatementContext c)
    {
        visitStatement(c).compute();
    }

    public static void main(String[] args) {
        String test = "func abc(x1): a:= 12; return a;"+
                "x:=12; y := - x; x:=2*x-y;";
        LangLexer lexer = new LangLexer(CharStreams.fromString(test));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ProgramContext context = p.program();
        System.out.println(context.f.size());
        context.st.forEach(Runner::compile);
        variables.forEach((k,v)->System.out.println(k+" = "+v));

    }
}
