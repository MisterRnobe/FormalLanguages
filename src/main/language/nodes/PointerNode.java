package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.IntegerType;

public class PointerNode extends ExpressionNode implements Assignable {
    private ExpressionNode node;
    public PointerNode(ExpressionNode node)
    {
        this.node = node;
    }
    @Override
    public IntegerType eval(VariablesPool pool) {
        IntegerType val;
        AbstractType t =node.eval(pool);
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
    public void assign(VariablesPool pool, AbstractType<?> value) {
        int index = eval(pool).getValue();
        try{
           pool.set(index, value);
        } catch (IndexOutOfBoundsException e)
        {
            throw new RuntimeException("Wrong pointer!");
        }

    }
}
