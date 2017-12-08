package main.language.nodes;

import main.language.errors.ReturnCallMessage;
import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.VoidType;

import java.util.List;

public class ConditionBlockNode extends StatementNode {
    private final List<StatementNode> ifBody, elseBody;
    public ConditionBlockNode(ConditionNode condition, List<StatementNode> ifBody, List<StatementNode> elseBody) {
        super(condition);
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public AbstractType<?> execute(VariablesPool pool) throws ReturnCallMessage {
        ConditionNode c = (ConditionNode) node;
        if (c.eval(pool).getValue() != 0)
            ifBody.forEach(n-> n.execute(pool));
        else
            if (elseBody != null) {
                elseBody.forEach(n -> n.execute(pool));
                //System.out.println(elseBody.size());
            }
        return new VoidType();
    }
}
