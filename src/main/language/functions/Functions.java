package main.language.functions;

import main.gui.ApplicationController;
import main.language.Function;
import main.language.Runner;
import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Functions {
    public static final Function sin = new Sin();
    public static final Function print = new Print();
    public static final Function pow = new Pow();
    public static final Function len = new Len();
    static class Sin extends Function
    {

        private Sin() {
            super(null, null, null, "sin");

        }

        @Override
        public AbstractType<?> executeFor(List<AbstractType<?>> values) {
            if (values.size()!= 1)
                throw new RuntimeException("Wrong number of arguments!");
            AbstractType<? extends Number> var = (AbstractType<? extends Number>) values.get(0);
             return new DoubleType(Math.sin(var.getValue().doubleValue()));
        }
    }
    static class Print extends Function
    {

        private Print() {
            super(null, null, null, "print");
        }

        @Override
        public AbstractType<?> executeFor(List<AbstractType<?>> values) {
            String s = values.stream().map(String::valueOf).
                    collect(Collectors.joining(" "));
            ApplicationController.getOutput().println(s);
            return new IntegerType(s.length());
        }
    }
    static class Len extends Function
    {

        public Len() {
            super(null, null, null, "len");
        }

        @Override
        public AbstractType<?> executeFor(List<AbstractType<?>> values) {
            if (values.size()!= 1)
                throw new RuntimeException("Wrong number of arguments!");
            return new IntegerType(values.get(0).getValue().toString().length());
        }
    }
    static class Pow extends Function
    {
        private Pow() {
            super(null, null, null, "pow");
        }

        @Override
        public AbstractType<?> executeFor(List<AbstractType<?>> values) {
            if (values.size() != 2)
                throw new RuntimeException("Wrong number of arguments!");
            AbstractType<? extends Number> var1 = (AbstractType<? extends Number>) values.get(0),
                var2 = (AbstractType<? extends Number>) values.get(1);
            return new DoubleType(Math.pow(var1.getValue().doubleValue(), var2.getValue().doubleValue()));
        }
    }
}
