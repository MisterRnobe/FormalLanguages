package main.language.nodes.statements;

import main.language.mem.Memory;
import main.language.nodes.ConditionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.state.ReturnedState;
import main.language.state.RunState;
import main.language.state.State;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class WhileNode implements Statementable {
    private List<Statementable> subProgram;
    private ConditionNode condition;

    public WhileNode(List<Statementable> subProgram, ConditionNode condition) {
        this.subProgram = subProgram;
        this.condition = condition;
    }

    @Override
    public State execute(Stack<Memory> memoryStack) {
        Memory temp = new Memory();
        State result = null;
        memoryStack.push(temp);
        while (condition.eval(memoryStack).getValue() != 0)
        {
            Optional<State> s = subProgram.stream().map(statement-> statement.execute(memoryStack)).filter(state-> state.getClass() != RunState.class).
                    findFirst();
            if (s.isPresent() && s.get().getClass() == ReturnedState.class)
                result = s.get();
        }
        if (result == null)
            result = new RunState();
        if (temp!= memoryStack.pop())
            throw new RuntimeException("Memory stack error!");
        temp.clear();

        return result;
    }

}
