package main.language.nodes;

import main.language.Function;
import main.language.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FunctionNode extends ExpressionNode{
    private Function function;
    private List<ExpressionNode> arguments;

    public FunctionNode(Function function, List<ExpressionNode> arguments) {
        this.function = function;
        this.arguments = arguments;
    }


    @Override
    public double eval(Runner.MyMap map)
    {
        return function.executeFor(arguments.stream().map(node-> node.eval(map)).collect(toList()));
    }

    @Override
    public String toString() {
        return function.getName()+"( "+arguments.stream().map(ExpressionNode::toString).collect(Collectors.joining(","))+" )";// TODO: 01.12.2017
    }


}
