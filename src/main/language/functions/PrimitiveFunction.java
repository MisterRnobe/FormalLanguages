package main.language.functions;

import main.language.Function;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import main.language.types.StringType;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static main.language.types.AbstractType.Type.VOID;
import static main.language.types.AbstractType.Type.INTEGER;
import static main.language.types.AbstractType.Type.DOUBLE;
import static main.language.types.AbstractType.Type.STRING;

public class PrimitiveFunction extends Function {
    //public static final Function sum = new PrimitiveFunction("+", (i1,i2)-> i1+i2, (d1,d2)-> d1.doubleValue()+d2.doubleValue());
    public static final Function sub = new PrimitiveFunction("-",
            Arrays.asList(PrimitiveFunction::integers, PrimitiveFunction::integers),
            Arrays.asList((t1,t2)-> computeIntegers(t1,t2, (i1,i2) -> i1 - i2),
                    (t1,t2)-> computeDoubles(t1,t2, (d1,d2)-> d1 - d2)));

    public static final Function div = new PrimitiveFunction("/",
            Arrays.asList(PrimitiveFunction::integers, PrimitiveFunction::integers),
            Arrays.asList((t1,t2)-> computeIntegers(t1,t2, (i1,i2) -> i1 / i2),
                    (t1,t2)-> computeDoubles(t1,t2, (d1,d2)-> d1 / d2)));
    public static final Function mod = new PrimitiveFunction("%",
            Collections.singletonList(PrimitiveFunction::integers),
            Collections.singletonList((t1, t2) -> computeIntegers(t1, t2, (i1, i2) -> i1 % i2)));

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
        return type1.getType() == INTEGER && type2.getType() == INTEGER;
    }
    private static boolean doubles(AbstractType<?> type1, AbstractType<?> type2)
    {
        return type1.getType() == DOUBLE && type2.getType() == DOUBLE ||
                type1.getType() == DOUBLE && type2.getType() == INTEGER ||
                type1.getType() == INTEGER && type2.getType() == DOUBLE;
    }
    private static boolean strings(AbstractType<?> type1, AbstractType<?> type2)
    {
        return type1.getType() == STRING || type2.getType() == STRING;
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

    /*Non-static fields*/
    private Map<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>,
            BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>> map;

    private PrimitiveFunction(String name, List<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>> predicates,
                              List<BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>> actions)
    {
        super(null,  null, name);
        if (predicates.size()!= actions.size())
            throw new RuntimeException("Number of predicates is not equal to number of actions!");
        map  = new LinkedHashMap<>();
        for (int i = 0; i < predicates.size(); i++) {
            map.put(predicates.get(i), actions.get(i));
        }
    }
    @Override
    public AbstractType<?> executeFor(List<AbstractType<?>> values)
    {
        Optional<Map.Entry<BiFunction<AbstractType<?>, AbstractType<?>, Boolean>,
                BiFunction<AbstractType<?>, AbstractType<?>, AbstractType<?>>>> o =
                map.entrySet().stream().filter(e-> e.getKey().apply(values.get(0), values.get(1))).findFirst();
        if (o.isPresent())
        {
            return o.get().getValue().apply(values.get(0), values.get(1));
        }
        else
        throw new RuntimeException("Operation '"+getName()+"' is not supported between "+
                values.get(0).getType()+" and "+values.get(1).getType());
    }

}
