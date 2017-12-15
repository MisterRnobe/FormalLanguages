package main.language.nodes;

import main.language.Function;
import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FunctionNode implements ExpressionNode {
    private Function function;
    private List<ExpressionNode> arguments;

    public FunctionNode(Function function, List<ExpressionNode> arguments) {
        this.function = function;
        this.arguments = arguments;
    }


    @Override
    public AbstractType<?> eval(Stack<Memory> memoryStack)
    {
        // TODO: 15.12.2017  
        return function.executeFor(arguments.stream().map(node->node.eval(memoryStack)).collect(toList()));
    }

    @Override
    public String toString() {
        return function.getName()+"( "+arguments.stream().map(ExpressionNode::toString).collect(Collectors.joining(","))+" )";// TODO: 01.12.2017
    }



}
