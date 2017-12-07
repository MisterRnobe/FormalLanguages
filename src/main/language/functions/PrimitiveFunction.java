package main.language.functions;

import main.language.Function;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import main.language.types.StringType;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class PrimitiveFunction extends Function {

    public static final Function sub = new PrimitiveFunction("-", (i1,i2)-> i1-i2, (d1,d2)-> d1.doubleValue()-d2.doubleValue());
    //public static final Function mul = new PrimitiveFunction("*", (i1,i2)-> i1*i2, (d1,d2)-> d1.doubleValue()*d2.doubleValue());
    public static final Function div = new PrimitiveFunction("/", (i1,i2)-> i1/i2, (d1,d2)-> d1.doubleValue()/d2.doubleValue());
    public static final Function mod = new PrimitiveFunction("%", (i1,i2)-> i1%i2, (d1,d2)-> {throw new RuntimeException("Operation '%' is supported only for integers!");});

    //public static final Function sum = new PrimitiveFunction("+", (i1,i2)-> i1+i2, (d1,d2)-> d1.doubleValue()+d2.doubleValue());

    public static final Function sum = new PrimitiveFunction("+",
            Arrays.asList(PrimitiveFunction::integers, PrimitiveFunction::strings, PrimitiveFunction::doubles)
    , Arrays.asList((type, type2) -> new IntegerType(((IntegerType)type).getValue()+((IntegerType)type2).getValue()),
            (type, type2) -> new StringType(type.getValue().toString()+ type2.getValue().toString()),
            (type, type2) -> computeDoubles(type, type2, (d1,d2)-> d1+d2)));
    public static final Function mul = new PrimitiveFunction("*",
            Arrays.asList(PrimitiveFunction::integers, (type, type2) -> type.getType() == AbstractType.Type.INTEGER && type2.getType() == AbstractType.Type.STRING, PrimitiveFunction::doubles),
            Arrays.asList((t1, t2) -> computeIntegers(t1, t2, (i1, i2) -> i1 * i2), (type, type2) -> {
                int val = ((IntegerType) type).getValue();
                StringBuilder b = new StringBuilder(val*type2.getValue().toString().length());
                for (int i = 0; i < val; i++) {
                    b.append(type2.getValue().toString());
                }
                return new StringType(b.toString());
            },(v1, v2) -> computeDoubles(v1, v2, (d1,d2)->d1*d2)));

    private static boolean integers(AbstractType<?> type1, AbstractType<?> type2)
    {
        return type1.getType() == AbstractType.Type.INTEGER && type2.getType() == AbstractType.Type.INTEGER;
    }
    private static boolean doubles(AbstractType<?> type1, AbstractType<?> type2)
    {
        return type1.getType() == AbstractType.Type.DOUBLE || type2.getType() == AbstractType.Type.DOUBLE;
    }
    private static boolean strings(AbstractType<?> type1, AbstractType<?> type2)
    {
        return type1.getType() == AbstractType.Type.STRING || type2.getType() == AbstractType.Type.STRING;
    }
    private static IntegerType computeIntegers(AbstractType<?> val1, AbstractType<?> val2, BinaryOperator<Integer> i)
    {
        IntegerType v1 = (IntegerType) val1, v2 = (IntegerType) val2;
        return new IntegerType(i.apply(v1.getValue(), v2.getValue()));
    }
    private static DoubleType computeDoubles(AbstractType<?> val1, AbstractType<?> val2, BinaryOperator<Double> d)
    {

        AbstractType<? extends Number> v1 = (AbstractType<? extends Number>) val1, v2 = (AbstractType<? extends Number>) val2;
        return new DoubleType(d.apply(v1.getValue().doubleValue(), v2.getValue().doubleValue()));
    }
    private static StringType computeString(AbstractType<?> val1, AbstractType<?> val2, BinaryOperator<String> s)
    {
        return new StringType(s.apply(val1.getValue().toString(), val2.getValue().toString()));
    }

    private BiFunction<Integer, Integer, Integer> ints;
    private BiFunction<Number,Number, Double> doubles;
    private Map<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>,
            BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>> map;

    private PrimitiveFunction(String name, List<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>> predicates,
                              List<BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>> actions)
    {
        super(null, null, null, name);
        if (predicates.size()!= actions.size())
            throw new RuntimeException("Number of predicates is not equal to number of actions!");
        map  = new HashMap<>();
        for (int i = 0; i < predicates.size(); i++) {
            map.put(predicates.get(i), actions.get(i));
        }
    }
    @Override
    public AbstractType<?> executeFor(List<AbstractType<?>> values)
    {
        for (Map.Entry<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>,
                BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>> e: map.entrySet()) {
            if (e.getKey().apply(values.get(0), values.get(1)))
                return e.getValue().apply(values.get(0), values.get(1));
        }
        throw new RuntimeException("Operation '"+getName()+"' is not supported between "+
                values.get(0).getType()+" and "+values.get(1).getType());
    }

    private PrimitiveFunction(String name, BiFunction<Integer, Integer, Integer> ints,
                             BiFunction<Number,Number, Double> doubles) {
        super(null, null, null, name);
        this.ints = ints;
        this.doubles = doubles;
    }

}
