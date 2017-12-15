package main.language.nodes;

import main.language.mem.Memory;
import main.language.nodes.interfaces.Assignable;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

import java.util.Stack;

public class VariableNode implements Assignable, ExpressionNode {
    private boolean hasPointer;
    private Token token;

    public VariableNode(Token t)
    {
        this(t, false);
    }
    public VariableNode(Token token, boolean hasPointer) {
        this.token = token;
        this.hasPointer = hasPointer;
    }

    @Override
    public AbstractType<?> eval(Stack<Memory> memoryStack) {
        if (hasPointer)
        {
            Integer result = null;
            for (int i = memoryStack.size() - 1; i >= 0; i--) {
                if ((result = memoryStack.get(i).getAddress(token.getText())) != null)
                    break;
            }
            if (result == null)
                throw new RuntimeException("Variable "+token.getText()+" was not found!");
            else
                return new IntegerType(result);
        }
        else
        {
            AbstractType<?> result = null;
            for (int i = memoryStack.size() - 1; i >= 0; i--) {
                if ((result = memoryStack.get(i).getValue(token.getText())) != null)
                    break;
            }
            if (result == null)
                throw new RuntimeException("Variable "+token.getText()+" was not found!");
            else
                return result;
        }
    }


    @Override
    public String toString() {
        return (hasPointer? "*": "")+token.getText();
    }


    public String getName()
    {
        return token.getText();
    }

    @Override
    public void assign(AbstractType<?> value, Stack<Memory> memoryStack) {
        for (int i = memoryStack.size() - 1; i >= 0; i--) {
            if (memoryStack.get(i).getValue(token.getText()) != null) {
                memoryStack.get(i).putValue(token.getText(), value);
                return;
            }
        }
        memoryStack.peek().putValue(token.getText(), value);
        //Memory.getGlobalMemory().putValue(this.getName(), value);
    }
}
