package main.language.functions;

import main.gui.ApplicationController;
import main.language.Function;
import main.language.Runner;
import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;
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
    static class Sin extends Function
    {

        private Sin() {
            super(null, null, null, "sin");

        }

        @Override
        public double executeFor(List<Double> values) {
            if (values.size()!= 1)
                throw new RuntimeException("Wrong number of arguments!");
            values.forEach(System.out::println);
            return Math.sin(values.get(0));
        }
    }
    static class Print extends Function
    {

        private Print() {
            super(null, null, null, "print");
        }

        @Override
        public double executeFor(List<Double> values) {
            ApplicationController.getOutput().println(values.stream().map(String::valueOf).
            collect(Collectors.joining(" ")));
            return 0;
        }
    }
    static class Pow extends Function
    {
        private Pow() {
            super(null, null, null, "pow");
        }

        @Override
        public double executeFor(List<Double> values) {
            if (values.size() != 2)
                throw new RuntimeException("Wrong number of arguments!");
            return Math.pow(values.get(0), values.get(1));
        }
    }
}
