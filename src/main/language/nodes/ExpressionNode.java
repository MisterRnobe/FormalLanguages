package main.language.nodes;

import main.language.LangLexer;
import main.language.LangParser;
import org.antlr.v4.runtime.Token;

public abstract class ExpressionNode {

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
        if (ctx.num != null)
        {
            return new NumberNode(ctx.num);
        }
        else
        {
            return visitExpr(ctx.expr());
        }
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

    //Non-static variables
    protected Token t;
    public abstract double eval();
    public abstract String toString();
}
