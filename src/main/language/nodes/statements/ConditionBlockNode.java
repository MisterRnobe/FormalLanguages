package main.language.nodes.statements;

import main.language.mem.Memory;
import main.language.nodes.ConditionNode;
import main.language.nodes.interfaces.Statementable;
import main.language.state.RunState;
import main.language.state.State;

import java.util.List;
import java.util.Stack;

public class ConditionBlockNode implements Statementable {
    private List<Statementable> ifStatements, elseStatements;
    private ConditionNode node;

    public ConditionBlockNode(ConditionNode node, List<Statementable> ifStatements, List<Statementable> elseStatements) {
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
        this.node = node;
    }


    @Override
    public State execute(Stack<Memory> memoryStack){
        Memory temp = new Memory();
        memoryStack.push(temp);
        State result;
        if (node.eval(memoryStack).getValue() != 0)
            result = ifStatements.stream().map(statement-> statement.execute(memoryStack)).filter(state->state.getClass() != RunState.class).findFirst().orElse(new RunState());
        else
            if (elseStatements != null)
                result = elseStatements.stream().map(statement-> statement.execute(memoryStack)).filter(s->s.getClass()!= RunState.class).findFirst().orElse(new RunState());
            else
                result = new RunState();
        if (temp != memoryStack.pop())
            throw new RuntimeException("Memory stack error!");
        temp.clear();
        return result;
    }
}
