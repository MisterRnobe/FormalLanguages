package main.language.nodes;

import main.language.errors.ReturnCallMessage;
import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.VoidType;

public class ReturnNode extends StatementNode {

    public ReturnNode(ExpressionNode reply) {
        super(reply);
    }

    @Override
    public AbstractType<?> execute(VariablesPool pool) {
        AbstractType<?> type = node == null? new VoidType(): node.eval(pool);
        throw new ReturnCallMessage(type);
    }

    @Override
    public String toString() {
        return null;
    }
}
