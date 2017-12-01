package main.language.nodes;

import main.language.Runner;
import org.antlr.v4.runtime.Token;

public class AssignmentNode extends ExpressionNode {
    private VariableNode variableNode;
    private ExpressionNode expressionNode;
    public AssignmentNode(VariableNode variableNode, Token t, ExpressionNode expressionNode) {
        super(t);
        this.expressionNode = expressionNode;
        this.variableNode = variableNode;
    }

    @Override
    public double eval(Runner.MyMap map) {
        double value = expressionNode.eval(map);
        map.update(variableNode.getName(), value);
        return expressionNode.eval(map);
    }

    @Override
    public String toString() {
        return variableNode.toString()+"="+expressionNode.toString();
    }

}
