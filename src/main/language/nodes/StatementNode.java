package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;

public class StatementNode {
    protected ExpressionNode node;

    public StatementNode(ExpressionNode node) {
        this.node = node;
    }
    public AbstractType<?> execute(VariablesPool pool)
    {
        return node.eval(pool);
    }
}
