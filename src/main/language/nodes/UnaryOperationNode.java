package main.language.nodes;

import org.antlr.v4.runtime.Token;

public class UnaryOperationNode extends ExpressionNode{
    private ExpressionNode node;
    public UnaryOperationNode(Token t, ExpressionNode node)
    {
        super(t);
        this.node = node;
    }

    @Override
    public double eval() {
        if (t.getText().equals("-"))
            return -node.eval();
        throw new RuntimeException("Unexpected symbol: "+t.getText()+" at "+t.getLine());
    }

    @Override
    public String toString() {
        return t.getText()+"("+node.toString()+")";
    }
}
