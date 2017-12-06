package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.IntegerType;
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
    public IntegerType eval(VariablesPool pool) {
        return compare(pool)? new IntegerType(1): new IntegerType(0);
    }

    @Override
    public String toString() {
        return "(" +left.toString()+t.getText()+right.toString()+")";
    }


    private boolean compare(VariablesPool pool)
    {
        AbstractType<? extends Number> leftValue = (AbstractType<? extends Number>)left.eval(pool);
        AbstractType<? extends Number> rightValue = (AbstractType<? extends Number>)right.eval(pool);
        if (t.getText().equals("=="))
            return leftValue == rightValue;
        else
            if (t.getText().equals("<"))
                return leftValue.getValue().doubleValue() < rightValue.getValue().doubleValue();
        else
            if (t.getText().equals(">"))
                return leftValue.getValue().doubleValue() > rightValue.getValue().doubleValue();
        throw new RuntimeException("Unexpected symbol: "+t.getText());
    }
}
