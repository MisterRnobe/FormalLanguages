package main.language.functions;

import main.language.Function;
import main.language.Runner;
import main.language.nodes.ExpressionNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;

import java.util.List;
import java.util.stream.Collectors;

public class Functions {
    public static Function sin = new Sin();
    public static Function print = new Print();
    static class Sin extends Function
    {

        private Sin() {
            super(null, null, null, "sin");
        }

        @Override
        public double executeFor(List<ExpressionNode> values) {
            if (values.size()!= 1)
                throw new RuntimeException("Wrong number of arguments!");
            return Math.sin(values.get(0).eval(new Runner.MyMap()));
        }
    }
    static class Print extends Function
    {

        private Print() {
            super(null, null, null, "print");
        }

        @Override
        public double executeFor(List<ExpressionNode> values) {
            System.out.println(values.stream().map(e -> String.valueOf(e.eval(new Runner.MyMap()))).
            collect(Collectors.joining(", ")));
            return 0;
        }
    }
}
