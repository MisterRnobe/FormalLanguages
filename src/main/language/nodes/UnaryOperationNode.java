package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.Token;

public class UnaryOperationNode extends ExpressionNode{
    private ExpressionNode node;
    public UnaryOperationNode(Token t, ExpressionNode node)
    {
        super(t);
        this.node = node;
    }


    @Override
    public AbstractType<?> eval(VariablesPool pool) {
        if (t.getText().equals("-"))
        {
            AbstractType<?> val = node.eval(pool);
            switch (val.getType())
            {
                case DOUBLE:
                    return new DoubleType(-(Double) val.getValue());
                case INTEGER:
                    return new IntegerType(-(Integer) val.getValue());
                default:
                    throw new RuntimeException("Unexpected type for operator '-' : "+val.getType());
            }
        }
        else
            if (t.getText().equals("*"))
            {
                AbstractType<?> val = node.eval(pool);
                if (val.getType()!= AbstractType.Type.INTEGER)
                    throw new RuntimeException("Unexpected type for operator '*': "+val.getValue());
                IntegerType i = (IntegerType) val;
                return pool.get(i.getValue()).getValue();
            }
        throw new RuntimeException("Unexpected symbol: "+t.getText()+" at "+t.getLine());
    }

    @Override
    public String toString() {
        return t.getText()+"("+node.toString()+")";
    }

}
