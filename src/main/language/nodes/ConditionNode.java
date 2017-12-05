package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public class ConditionNode extends ExpressionNode {
    private Token t;
    private ExpressionNode left;
    private ExpressionNode right;
    public ConditionNode(ExpressionNode left, Token t, ExpressionNode right)
    {
        this.left= left;
        this.t = t;
        this.right = right;
    }
    @Override
    public double eval(Runner.MyMap nodes) {
        return compare(nodes)? 1d: 0d;
    }

    @Override
    public String toString() {
        return "(" +left.toString()+t.getText()+right.toString()+")";
    }
    private boolean compare(Runner.MyMap nodes)
    {
        double leftValue = left.eval(nodes);
        double rightValue = right.eval(nodes);
        if (t.getText().equals("=="))
            return leftValue == rightValue;
        else
            if (t.getText().equals("<"))
                return leftValue < rightValue;
        else
            if (t.getText().equals(">"))
                return leftValue > rightValue;
        throw new RuntimeException("Unexpected symbol: "+t.getText());
    }
}
