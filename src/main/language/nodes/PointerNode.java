package main.language.nodes;

import main.language.mem.Memory;
import main.language.nodes.interfaces.Assignable;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import main.language.types.IntegerType;

import java.util.Stack;

public class PointerNode implements Assignable, ExpressionNode {
    private ExpressionNode node;
    public PointerNode(ExpressionNode node)
    {
        this.node = node;
    }
    @Override
    public IntegerType eval(Stack<Memory> memoryStack) {
        IntegerType val;
        AbstractType t = node.eval( memoryStack);
        try
        {
            val = (IntegerType) t;
        }
        catch (ClassCastException e)
        {
            throw new RuntimeException("Pointer must be INTEGER. Found: "+t.getType());
        }
        return val;
    }

    @Override
    public String toString() {
        return "*"+node.toString();
    }

    @Override
    public void assign(AbstractType<?> value, Stack<Memory> memoryStack) {
        int index = eval(memoryStack).getValue();
        try{
            Memory.getGlobalMemory().write(index, value);
        } catch (IndexOutOfBoundsException e)
        {
            throw new RuntimeException("Wrong pointer!");
        }

    }
}
