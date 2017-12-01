package main.language.nodes;

import main.language.Function;
import main.language.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionNode extends ExpressionNode{
    private Function function;
    private List<ExpressionNode> arguments;

    public FunctionNode(Function function, List<ExpressionNode> arguments) {
        this.function = function;
        this.arguments = arguments;
    }


    @Override
    public double eval(Runner.MyMap map) {//CHECK
        return function.executeFor(arguments);
    }

    @Override
    public String toString() {
        return function.getName()+"( "+arguments.stream().map(ExpressionNode::toString).collect(Collectors.joining(","))+" )";// TODO: 01.12.2017
    }


}
