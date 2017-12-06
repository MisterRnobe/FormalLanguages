package main.language;

import main.language.misc.VariablesPool;
import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;
import main.language.types.AbstractType;

import java.util.List;

public class Function {
    private List<StatementNode> body;
    protected List<VariableNode> arguments;
    private ExpressionNode result;
    private String name;

    public Function(List<StatementNode> body, List<VariableNode> arguments, ExpressionNode result, String name) {
        this.body = body;
        this.arguments = arguments;
        this.result = result;
        this.name = name;
    }
    public AbstractType<?> executeFor(List<AbstractType<?>> values)
    {
        if (values.size() != arguments.size())
            throw new RuntimeException("Wrong arguments number");
        VariablesPool localVars = new VariablesPool();
        for (int i = 0; i < arguments.size(); i++) {
            localVars.update(arguments.get(i).getName(), values.get(i));
        }
//        for (int i = 0; i < arguments.size(); i++) {
//            localVars.update(arguments.get(i).getName(), values.get(i).eval(localVars));
//        }
        body.forEach(statementNode -> statementNode.execute(localVars));
        return result.eval(localVars);// TODO: 01.12.2017 Implement algorithm
    }

    public String getName() {
        return name;
    }
}
