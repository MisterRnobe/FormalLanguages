package main.language.nodes;

import main.language.LangLexer;
import main.language.LangParser;
import org.antlr.v4.runtime.Token;

public abstract class ExpressionNode {

    //Non-static fields and methods
    private ExpressionNode()
    {

    }
    protected ExpressionNode(Token t)
    {
        this.t = t;
    }
    protected Token t;
    public abstract double eval();
    public abstract String toString();
}
