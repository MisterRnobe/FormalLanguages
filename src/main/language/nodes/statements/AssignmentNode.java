package main.language.nodes.statements;

import main.language.mem.Memory;
import main.language.nodes.interfaces.Assignable;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.state.RunState;
import main.language.state.State;
import main.language.types.AbstractType;

import java.util.List;
import java.util.Stack;

public class AssignmentNode implements Statementable {
    private Assignable assignable;
    private ExpressionNode expressionNode;
    public AssignmentNode(Assignable assignable, ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
        this.assignable = assignable;
    }

    @Override
    public String toString() {
        return assignable.toString()+" := "+expressionNode.toString();
    }


    @Override
    public State execute(Stack<Memory> memoryStack) {
        AbstractType<?> value = expressionNode.eval(memoryStack);
        assignable.assign(value, memoryStack);
        return new RunState();
    }
}
