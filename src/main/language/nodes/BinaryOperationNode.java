package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public class BinaryOperationNode extends ExpressionNode{
    private final ExpressionNode left,right;

    public BinaryOperationNode(ExpressionNode left, Token t, ExpressionNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    @Override
    public double eval(Runner.MyMap map) {
        return get(left.eval(map), right.eval(map));
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
