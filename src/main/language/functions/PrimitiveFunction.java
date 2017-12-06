package main.language.functions;

import main.language.Function;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;

import java.util.List;
import java.util.function.BiFunction;

public class PrimitiveFunction extends Function {

    public static final Function sum = new PrimitiveFunction("sum", (i1,i2)-> i1+i2, (d1,d2)-> d1.doubleValue()+d2.doubleValue());
    public static final Function sub = new PrimitiveFunction("sub", (i1,i2)-> i1-i2, (d1,d2)-> d1.doubleValue()-d2.doubleValue());
    public static final Function mul = new PrimitiveFunction("mul", (i1,i2)-> i1*i2, (d1,d2)-> d1.doubleValue()*d2.doubleValue());
    public static final Function div = new PrimitiveFunction("div", (i1,i2)-> i1/i2, (d1,d2)-> d1.doubleValue()/d2.doubleValue());
    public static final Function mod = new PrimitiveFunction("mod", (i1,i2)-> i1%i2, (d1,d2)-> {throw new RuntimeException("Operation '%' is supported only for integers!");});




    private BiFunction<Integer, Integer, Integer> ints;
    private BiFunction<Number,Number, Double> doubles;

    private PrimitiveFunction(String name, BiFunction<Integer, Integer, Integer> ints,
                             BiFunction<Number,Number, Double> doubles) {
        super(null, null, null, name);
        this.ints = ints;
        this.doubles = doubles;
    }
    @Override
    public AbstractType<?> executeFor(List<AbstractType<?>> values) {
        if (values.get(0).getType() == AbstractType.Type.DOUBLE || values.get(1).getType() == AbstractType.Type.DOUBLE)
            return computeDoubles(values.get(0), values.get(1));
        else
        if (values.get(0).getType() == AbstractType.Type.INTEGER && values.get(1).getType() == AbstractType.Type.INTEGER)
            return computeIntegers(values.get(0), values.get(1));
        else
            throw new RuntimeException("Operation '+' is not supported between "+
                    values.get(0).getType()+" and "+values.get(1).getType());
    }
    IntegerType computeIntegers(AbstractType<?> val1, AbstractType<?> val2)
    {
        IntegerType v1 = (IntegerType) val1, v2 = (IntegerType) val2;
        return new IntegerType(ints.apply(v1.getValue(),v2.getValue()));
    }
    DoubleType computeDoubles(AbstractType<?> val1, AbstractType<?> val2)
    {

        AbstractType<? extends Number> v1 = (AbstractType<? extends Number>) val1, v2 = (AbstractType<? extends Number>) val2;
        return new DoubleType(doubles.apply(v1.getValue(), v2.getValue()));
    }
}
