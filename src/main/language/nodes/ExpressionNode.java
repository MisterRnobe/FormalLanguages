package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public abstract class ExpressionNode {

    //Non-static fields and methods
    ExpressionNode()
    {

    }
    ExpressionNode(Token t)
    {
        this.t = t;
    }
    Token t;
    public abstract double eval(Runner.MyMap nodes);
    public abstract String toString();
}
