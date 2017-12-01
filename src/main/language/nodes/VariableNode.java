package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public class VariableNode extends ExpressionNode{
    public VariableNode(Token t) {
        super(t);
    }

    @Override
    public double eval() {
        Double value = Runner.get(getName());
        if (value == null)
            throw new RuntimeException("Variable "+getName()+" was not declared!");
        return value;
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
