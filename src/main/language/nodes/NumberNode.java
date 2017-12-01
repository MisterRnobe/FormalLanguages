package main.language.nodes;

import org.antlr.v4.runtime.Token;

public class NumberNode extends ExpressionNode {

    public NumberNode(Token t)
    {
        super(t);
    }
    @Override
    public double eval() {
        return Double.valueOf(t.getText());
    }

    @Override
    public String toString() {
        return t.getText();
    }
}
