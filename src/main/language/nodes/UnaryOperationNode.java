package main.language.nodes;

import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

import java.util.Stack;

public class UnaryOperationNode implements ExpressionNode {
    private ExpressionNode node;
    private Token token;
    public UnaryOperationNode(Token token, ExpressionNode node)
    {
        this.token = token;
        this.node = node;
    }


    @Override
    public AbstractType<?> eval(Stack<Memory> memoryStack) {
        if (token.getText().equals("-"))
        {
            AbstractType<?> val = node.eval(memoryStack);
            switch (val.getType())
            {
                case DOUBLE:
                    return new DoubleType(-(Double) val.getValue());
                case INTEGER:
                    return new IntegerType(-(Integer) val.getValue());
                default:
                    throw new RuntimeException("Unexpected type for operator '-' : "+val.getType());
            }
        }
        else
            if (token.getText().equals("*"))
            {
                AbstractType<?> val = node.eval(memoryStack);
                if (val.getType()!= AbstractType.Type.INTEGER)
                    throw new RuntimeException("Unexpected type for operator '*': "+val.getValue());
                IntegerType i = (IntegerType) val;
                return Memory.getGlobalMemory().getByAddress(i.getValue());
            }
        throw new RuntimeException("Unexpected symbol: "+token.getText()+" at "+token.getLine());
    }


    @Override
    public String toString() {
        return token.getText()+"("+node.toString()+")";
    }

}
