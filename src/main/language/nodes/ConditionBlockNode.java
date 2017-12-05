package main.language.nodes;

import main.language.Runner;

import java.util.List;

public class ConditionBlockNode extends StatementNode {
    private final List<StatementNode> ifBody, elseBody;
    public ConditionBlockNode(ConditionNode condition, List<StatementNode> ifBody, List<StatementNode> elseBody) {
        super(condition);
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public void execute(Runner.MyMap map) {
        ConditionNode c = (ConditionNode) node;
        if (c.eval(map) != 0)
            ifBody.forEach(n-> n.execute(map));
        else
            if (elseBody != null) {
                elseBody.forEach(n -> n.execute(map));
                //System.out.println(elseBody.size());
            }
    }
}
