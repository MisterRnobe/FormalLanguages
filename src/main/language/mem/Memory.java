package main.language.mem;
import main.language.Function;
import main.language.functions.Functions;
import main.language.types.AbstractType;
import main.language.types.VoidType;

import java.util.*;

public class Memory {
    private static Memory globalMemory;

    public static Memory getGlobalMemory() {
        return globalMemory;
    }
    public static void init()
    {
        globalMemory = new Memory();
        functions = new LinkedList<>();
        AbstractType[] types = new AbstractType[heapSize];
        Arrays.setAll(types, i-> null);
        heap = Arrays.asList(types);
        initFunctions();
    }
    public static void destroy()
    {
        globalMemory = null;
    }

    private static List<AbstractType<?>> heap;
    private Map<String, Integer> variables;
    private static List<Function> functions;
    private static int heapSize = 1000;

    public Memory()
    {
        variables = new TreeMap<>();
    }
    private static void initFunctions()
    {
        functions.addAll(Arrays.asList(Functions.len, Functions.pow, Functions.print, Functions.sin, Functions.allocate));
    }
    public AbstractType<?> getValue(String x)
    {
        Integer index = variables.get(x);
        if (index == null)
            return null;//throw new RuntimeException("Variable "+x+" was not found!");
        else
            return heap.get(index);
    }
    public void putValue(String x, AbstractType value)
    {
        Integer index = variables.get(x);
        if (index == null)
        {
            index = allocate(1);
            heap.set(index, value);
            variables.put(x, index);
        }
        else
        {
            heap.set(index, value);
        }
    }
    public Integer getAddress(String x)
    {
        return variables.get(x);
    }
    public AbstractType getByAddress(Integer i)
    {
        AbstractType t = heap.get(i);
        if (t == null)
            throw new RuntimeException("No values in this address: "+i);
        return t;
    }
    public void write(Integer index, AbstractType value)
    {
        heap.set(index, value);
    }
    public int allocate(int size)
    {
        for (int i = 0; i < heapSize-size; i++) {
            boolean found = true;
            if (heap.get(i) == null) {
                for (int j = 1; j < size; j++) {
                    if (heap.get(i + j) != null) {
                        found = false;
                        break;
                    }
                }
                if (found)
                {
                    for (int j = 0; j < size; j++)
                        heap.set(i+j, new VoidType());
                    return i;
                }
            }
        }
        throw new RuntimeException("No memory!");
    }
    public Function getFunction(String name)
    {
        Optional<Function> f = functions.stream().filter(n->n.getName().equals(name)).findFirst();
        if (f.isPresent())
            return f.get();
        else
            throw new RuntimeException("Function "+name+" was not found!");
    }
    public void addFunction(Function f)
    {
        functions.add(f);
    }
    public void clear()
    {
        // TODO: 15.12.2017
    }

}
