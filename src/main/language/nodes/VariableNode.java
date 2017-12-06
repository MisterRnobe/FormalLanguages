package main.language.nodes;

import main.language.Runner;
import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import org.antlr.v4.runtime.Token;

public class VariableNode extends ExpressionNode{
    private AbstractType.Type type;
    public VariableNode(Token t) {
        super(t);
    }

    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        AbstractType<?> type = pool.getByName(t.getText());
        if (type == null)
            throw new RuntimeException("Variable "+t.getText()+" has not been found!");
        this.type = type.getType();
        return type;
    }

    @Override
    public String toString() {
        return t.getText();
    }


    public String getName()
    {
        return t.getText();
    }
}
