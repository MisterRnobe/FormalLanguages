package main.language.nodes;

import main.language.Runner;

public class StatementNode {
    protected ExpressionNode node;

    public StatementNode(ExpressionNode node) {
        this.node = node;
    }
    public void execute(Runner.MyMap map)
    {
        node.eval(map);
    }
}
