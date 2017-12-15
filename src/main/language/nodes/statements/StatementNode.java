package main.language.nodes.statements;

import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.state.RunState;
import main.language.state.State;

import java.util.List;
import java.util.Stack;

public class StatementNode implements Statementable {
    private ExpressionNode node;

    public StatementNode(ExpressionNode node) {
        this.node = node;
    }
    @Override
    public State execute(Stack<Memory> memoryStack)
    {
        node.eval(memoryStack);
        return new RunState();
    }
}
