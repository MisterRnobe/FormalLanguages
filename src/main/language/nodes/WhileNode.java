package main.language.nodes;

import main.language.errors.ReturnCallMessage;
import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.VoidType;

import java.util.List;

public class WhileNode extends StatementNode {
    public final List<StatementNode> subProgram;
    public WhileNode(ConditionNode node, List<StatementNode> subProgram) {
        super(node);
        this.subProgram = subProgram;
    }

    @Override
    public AbstractType<?> execute(VariablesPool pool) throws ReturnCallMessage {
        ConditionNode node =(ConditionNode) this.node;
        while (node.eval(pool).getValue()!=0d)
            subProgram.forEach(statementNode -> statementNode.execute(pool));
        return new VoidType();
    }
}
