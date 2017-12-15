package main.language.nodes;

import main.language.mem.Memory;
import main.language.nodes.interfaces.ExpressionNode;
import main.language.types.AbstractType;
import main.language.types.DoubleType;
import main.language.types.IntegerType;
import main.language.types.StringType;
import org.antlr.v4.runtime.Token;

import java.util.Stack;

public class LiteralNode implements ExpressionNode {
    private Token token;

    public LiteralNode(Token token)
    {
        this.token = token;
    }
    @Override
    public AbstractType<?> eval(Stack<Memory> memoryStack) {
        if (token.getText().contains("\""))
            return new StringType(token.getText().substring(1, token.getText().length()-1));
        else
            return token.getText().contains(".")? new DoubleType(Double.parseDouble(token.getText())):
                new IntegerType(Integer.parseInt(token.getText()));
    }
    

    @Override
    public String toString() {
        return token.getText();
    }

}
