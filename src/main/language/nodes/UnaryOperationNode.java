package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public class UnaryOperationNode extends ExpressionNode{
    private ExpressionNode node;
    public UnaryOperationNode(Token t, ExpressionNode node)
    {
        super(t);
        this.node = node;
    }

    @Override
    public double eval(Runner.MyMap map) {
        if (t.getText().equals("-"))
            return -node.eval(map);
        throw new RuntimeException("Unexpected symbol: "+t.getText()+" at "+t.getLine());
    }

    @Override
    public String toString() {
        return t.getText()+"("+node.toString()+")";
    }
}
