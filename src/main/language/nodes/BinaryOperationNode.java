package main.language.nodes;

import org.antlr.v4.runtime.Token;

public class BinaryOperationNode extends ExpressionNode{
    private final ExpressionNode left,right;

    public BinaryOperationNode(ExpressionNode left, Token t, ExpressionNode right) {
        this.left = left;
        this.right = right;
        this.t = t;
    }

    @Override
    public double eval() {
        return get(left.eval(), right.eval());
    }

    @Override
    public String toString() {
        return "("+left.toString()+ t.getText() + right.toString()+")";
    }
    private double get(double a, double b)
    {
        if (t.getText().equals("+"))
            return a+b;
        else
            if (t.getText().equals("-"))
                return a-b;
        else
            if (t.getText().equals("*"))
                return a*b;
        else
            if (t.getText().equals("/"))
                return a/b;
        throw new RuntimeException("Unexpected operator: "+t.getText()+"!");
    }
}
