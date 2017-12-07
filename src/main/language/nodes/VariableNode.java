package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

public class VariableNode extends ExpressionNode implements Assignable{
    private boolean hasPointer;
    public VariableNode(Token t)
    {
        this(t, false);
    }
    public VariableNode(Token t, boolean hasPointer) {
        super(t);
        this.hasPointer = hasPointer;
    }

    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        if (hasPointer)
        {
            int i = pool.getIndex(t.getText());
            if (i == -1)
                throw new RuntimeException("Variable "+t.getText()+" has not been found!");
            else
                return new IntegerType(i);
        }
        else {
            AbstractType<?> type = pool.getByName(t.getText());
            if (type == null)
                throw new RuntimeException("Variable " + t.getText() + " has not been found!");
            return type;
        }
    }

    @Override
    public String toString() {
        return t.getText();
    }


    public String getName()
    {
        return t.getText();
    }

    @Override
    public void assign(VariablesPool pool, AbstractType<?> value) {
        pool.update(t.getText(), value);
    }
}
