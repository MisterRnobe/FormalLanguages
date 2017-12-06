package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
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
    public AbstractType<?> eval(VariablesPool pool) {
        AbstractType<?> value = expressionNode.eval(pool);
        pool.update(variableNode.getName(), value);
        return value;
    }

    @Override
    public String toString() {
        return variableNode.toString()+"="+expressionNode.toString();
    }


}
