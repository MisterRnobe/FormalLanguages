package main.language.nodes.special_operators;

import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.state.ReturnedState;
import main.language.state.State;
import main.language.types.VoidType;

import java.util.List;
import java.util.Stack;

public class ReturnNode implements Statementable {
    private ExpressionNode result;
    public ReturnNode(ExpressionNode result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "return "+result.toString();
    }

    @Override
    public State execute(Stack<Memory> memoryStack) {
        return new ReturnedState(result == null? new VoidType(): result.eval(memoryStack));
    }
}
