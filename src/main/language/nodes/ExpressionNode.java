package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import org.antlr.v4.runtime.Token;

public abstract class ExpressionNode {
    protected Token t;
    ExpressionNode() {

    }
    ExpressionNode(Token t)
    {
        this.t = t;
    }

    public abstract AbstractType<?> eval(VariablesPool pool);
    public abstract String toString();
}
