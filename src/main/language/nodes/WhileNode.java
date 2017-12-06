package main.language.nodes;

import main.language.misc.VariablesPool;

import java.util.List;

public class WhileNode extends StatementNode {
    public final List<StatementNode> subProgram;
    public WhileNode(ConditionNode node, List<StatementNode> subProgram) {
        super(node);
        this.subProgram = subProgram;
    }

    @Override
    public void execute(VariablesPool pool) {
        ConditionNode node =(ConditionNode) this.node;
        while (node.eval(pool).getValue()!=0d)
            subProgram.forEach(statementNode -> statementNode.execute(pool));
    }
}
