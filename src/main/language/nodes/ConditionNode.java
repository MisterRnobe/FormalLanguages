package main.language.nodes;

import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

import java.util.Stack;

public class ConditionNode implements ExpressionNode {
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
    public IntegerType eval(Stack<Memory> memoryStack) {
        //return compare()? ;
        return new IntegerType(compare(memoryStack)?1:0);
    }

    @Override
    public String toString() {
        return "(" +left.toString()+t.getText()+right.toString()+")";
    }


    private boolean compare(Stack<Memory> memoryStack)
    {
        AbstractType<? extends Number> leftValue = (AbstractType<? extends Number>)left.eval(memoryStack);
        AbstractType<? extends Number> rightValue = (AbstractType<? extends Number>)right.eval(memoryStack);
        if (t.getText().equals("=="))
        {
            System.out.println("Left value is "+leftValue+", right one is "+rightValue);
            System.out.println("Result is "+(leftValue == rightValue));
            return leftValue.getValue().doubleValue() == rightValue.getValue().doubleValue();
        }

        else
            if (t.getText().equals("<"))
                return leftValue.getValue().doubleValue() < rightValue.getValue().doubleValue();
        else
            if (t.getText().equals(">"))
                return leftValue.getValue().doubleValue() > rightValue.getValue().doubleValue();
        throw new RuntimeException("Unexpected symbol: "+t.getText());
    }
}
