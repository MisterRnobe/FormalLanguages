package main.language.functions;

import main.language.Function;
import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;

import java.util.List;

public class Sum {
    public static final Function sum = new Add();
    public static class Add extends Function
    {
        Add() {
            super(null, null, null, null);
        }

        @Override
        public AbstractType<?> executeFor(List<AbstractType<?>> values) {
            if (values.get(0).getType() == AbstractType.Type.DOUBLE || values.get(1).getType() == AbstractType.Type.DOUBLE)
                return sumDoubles(values.get(0), values.get(1));
            else
                return sumIntInt(values.get(0), values.get(1));
        }
        public static IntegerType sumIntInt(AbstractType<?> val1, AbstractType<?> val2)
        {
            IntegerType v1 = (IntegerType) val1, v2 = (IntegerType) val2;
            return new IntegerType(v1.getValue()+v2.getValue());
        }
        public static DoubleType sumDoubles(AbstractType<?> val1, AbstractType<?> val2)
        {
            AbstractType<? extends Number> v1 = (AbstractType<? extends Number>) val1, v2 = (AbstractType<? extends Number>) val2;
            return new DoubleType(v1.getValue().doubleValue()+ v2.getValue().doubleValue());
        }
    }
}
