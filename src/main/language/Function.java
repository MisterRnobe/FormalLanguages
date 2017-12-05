package main.language;

import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;

import java.util.List;
import static main.language.Runner.MyMap;

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
    public double executeFor(List<Double> values)
    {
        if (values.size() != arguments.size())
            throw new RuntimeException("Wrong arguments number");
        MyMap localVars = new MyMap();
        for (int i = 0; i < arguments.size(); i++) {
            localVars.update(arguments.get(i).getName(), values.get(i));
        }
//        for (int i = 0; i < arguments.size(); i++) {
//            localVars.update(arguments.get(i).getName(), values.get(i).eval(localVars));
//        }
        body.forEach(statementNode -> statementNode.compute(localVars));
        return result.eval(localVars);// TODO: 01.12.2017 Implement algorithm
    }

    public String getName() {
        return name;
    }
}
