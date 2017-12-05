package main.language.nodes;

import main.language.Runner;

import java.util.List;

public class WhileNode extends StatementNode {
    public final List<StatementNode> subProgram;
    public WhileNode(ConditionNode node, List<StatementNode> subProgram) {
        super(node);
        this.subProgram = subProgram;
    }

    @Override
    public void execute(Runner.MyMap map) {
        ConditionNode node =(ConditionNode) this.node;
        while (node.eval(map)!=0d)
            subProgram.forEach(statementNode -> statementNode.execute(map));
    }
}
