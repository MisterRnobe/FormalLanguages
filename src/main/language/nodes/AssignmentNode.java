package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import org.antlr.v4.runtime.Token;

public class AssignmentNode extends ExpressionNode {
    private Assignable assignable;
    private ExpressionNode expressionNode;
    public AssignmentNode(Assignable assignable, Token t, ExpressionNode expressionNode) {
        super(t);
        this.expressionNode = expressionNode;
        this.assignable = assignable;
    }

    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        AbstractType<?> value = expressionNode.eval(pool);
        assignable.assign(pool, value);
        //pool.update(assignable.getName(), value);
        return value;
    }

    @Override
    public String toString() {
        return assignable.toString()+"="+expressionNode.toString();
    }


}
