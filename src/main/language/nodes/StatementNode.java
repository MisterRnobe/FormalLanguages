package main.language.nodes;

import main.language.Runner;

public class StatementNode {
    private ExpressionNode node;

    public StatementNode(ExpressionNode node) {
        this.node = node;
    }
    public void compute(Runner.MyMap map)
    {
        node.eval(map);
    }
}
