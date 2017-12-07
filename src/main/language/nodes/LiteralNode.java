package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import main.language.types.StringType;
import org.antlr.v4.runtime.Token;

public class LiteralNode extends ExpressionNode {

    public LiteralNode(Token t)
    {
        super(t);
    }
    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        if (t.getText().contains("\""))
            return new StringType(t.getText().substring(1, t.getText().length()-1));
        else
            return t.getText().contains(".")? new DoubleType(Double.parseDouble(t.getText())):
                new IntegerType(Integer.parseInt(t.getText()));
    }

    @Override
    public String toString() {
        return t.getText();
    }

}
