package main.language.nodes;

import main.language.misc.VariablesPool;

import java.util.List;

public class ConditionBlockNode extends StatementNode {
    private final List<StatementNode> ifBody, elseBody;
    public ConditionBlockNode(ConditionNode condition, List<StatementNode> ifBody, List<StatementNode> elseBody) {
        super(condition);
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public void execute(VariablesPool pool) {
        ConditionNode c = (ConditionNode) node;
        if (c.eval(pool).getValue() != 0)
            ifBody.forEach(n-> n.execute(pool));
        else
            if (elseBody != null) {
                elseBody.forEach(n -> n.execute(pool));
                //System.out.println(elseBody.size());
            }
    }
}
