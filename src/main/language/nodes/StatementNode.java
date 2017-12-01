package main.language.nodes;

public class StatementNode {
    private AssignmentNode node;

    public StatementNode(AssignmentNode node) {
        this.node = node;
    }
    public void compute()
    {
        node.eval();
    }
}
