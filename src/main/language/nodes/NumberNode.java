package main.language.nodes;

import main.language.Runner;
import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

public class NumberNode extends ExpressionNode {

    public NumberNode(Token t)
    {
        super(t);
    }
    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        return t.getText().contains(".")? new DoubleType(Double.parseDouble(t.getText())):
                new IntegerType(Integer.parseInt(t.getText()));
    }

    @Override
    public String toString() {
        return t.getText();
    }

}
