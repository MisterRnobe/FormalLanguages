package main.language.nodes;

import main.language.misc.VariablesPool;

public class StatementNode {
    protected ExpressionNode node;

    public StatementNode(ExpressionNode node) {
        this.node = node;
    }
    public void execute(VariablesPool pool)
    {
        node.eval(pool);
    }
}
