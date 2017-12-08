package main.language;

import main.language.errors.ReturnCallMessage;
import main.language.misc.VariablesPool;
import main.language.nodes.ExpressionNode;
import main.language.nodes.ReturnNode;
import main.language.nodes.StatementNode;
import main.language.nodes.VariableNode;
import main.language.types.AbstractType;
import main.language.types.IntegerType;
import main.language.types.VoidType;

import java.util.List;
import java.util.Optional;

public class Function {
    private List<StatementNode> body;
    private List<VariableNode> arguments;
    private String name;

    public Function(List<StatementNode> body, List<VariableNode> arguments, String name) {
        this.body = body;
        this.arguments = arguments;
        this.name = name;
    }
    public AbstractType<?> executeFor(List<AbstractType<?>> values)
    {
        if (values.size() != arguments.size())
            throw new RuntimeException("Wrong arguments number");
        VariablesPool localVars = new VariablesPool();
        for (int i = 0; i < arguments.size(); i++) {
            localVars.update(arguments.get(i).getName(), values.get(i));
        }

//        Optional<? extends AbstractType<?>> optional = body.stream().filter(node-> node.getClass()== ReturnNode.class).map(node->node.execute(localVars)).findFirst();//.orElse(new IntegerType(1));
//        AbstractType<?> result;
//        if (optional.isPresent())
//            result = optional.get();
//        else
//            result = new VoidType();
        AbstractType<?> result;
        try{
            body.forEach(n-> n.execute(localVars));
            result = new VoidType();
        }
        catch (ReturnCallMessage e)
        {
            result = e.getResult();
        }
        return result;
        //body.forEach(statementNode -> statementNode.execute(localVars));
        //return result.eval(localVars);// TODO: 01.12.2017 Implement algorithm
    }

    public String getName() {
        return name;
    }
}
