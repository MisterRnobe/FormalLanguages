package main.language;

import main.language.mem.Memory;
import main.language.nodes.VariableNode;
import main.language.nodes.interfaces.Statementable;
import main.language.nodes.statements.StatementNode;
import main.language.state.ReturnedState;
import main.language.state.State;
import main.language.types.AbstractType;
import main.language.types.VoidType;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Function {
    private List<Statementable> body;
    private List<VariableNode> arguments;
    private String name;

    public Function(List<Statementable> body, List<VariableNode> arguments, String name) {
        this.body = body;
        this.arguments = arguments;
        this.name = name;
    }
    public AbstractType<?> executeFor(List<AbstractType<?>> values)
    {
        if (values.size() != arguments.size())
            throw new RuntimeException("Wrong arguments number");
        for (int i = 0; i < arguments.size(); i++) {
            Memory.getGlobalMemory().putValue(arguments.get(i).getName(), values.get(i));
        }
        // TODO: 15.12.2017
        Optional<State> state =
                body.stream().map(node-> node.execute(new Stack<>())).filter(s->s.getClass() == ReturnedState.class).
                        findFirst();
        if (state.isPresent())
            return ((ReturnedState)state.get()).getValue();
        else
            return new VoidType();
        /*VariablesPool localVars = new VariablesPool();
        for (int i = 0; i < arguments.size(); i++) {
            localVars.update(arguments.get(i).getName(), values.get(i));
        }
        AbstractType<?> result;
        try{
            body.forEach(n-> n.execute(localVars));
            result = new VoidType();
        }
        catch (ReturnCallMessage e)
        {
            result = e.getResult();
        }
        return result;*/
        //body.forEach(statementNode -> statementNode.execute(localVars));

    }

    public String getName() {
        return name;
    }
}
