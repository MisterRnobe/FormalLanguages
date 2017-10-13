package lesson_three;

import lesson_two.ParseException;
import lesson_two.Token;

import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int index = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
    private ParseException error(String message)
    {
        int errorPosition;
        if (index >= tokens.size())
        {
            if (tokens.isEmpty())
            {
                errorPosition = 0;
            }
            else {
                Token last = tokens.get(tokens.size()-1);
                errorPosition = last.to;
            }
        }
        else
        {
            Token t = tokens.get(index);
            errorPosition = t.from;
        }
        return new ParseException(message,errorPosition);
    }
    private Token match(Token.TokenType type)
    {
        if (index>= tokens.size())
            return null;
        Token t = tokens.get(index);
        if (t.type == type)
        {
            index++;
            return t;
        }
        else
        {
            return null;
        }
    }
    //Expression = NUMBER('+'NUMBER)*
    //
    //
    public ExprNode1 parseExpression() throws ParseException
    {
        Token number1 = match(Token.TokenType.NUMBER);
        if ( number1 == null)
            throw error("A number is missed");
        ExprNode1 left = new ExprNode1(number1);
        while (true)
        {
            Token plus = match(Token.TokenType.PLUS);
            if (plus == null)
                break;
            else
            {
                Token number2 = match(Token.TokenType.NUMBER);
                if (number2 == null) throw error("A number is missed");
                ExprNode1 right = new ExprNode1(number2);
                ExprNode1 op = new ExprNode1(left,right, plus);
                left = op;
            }

        }
        return left;
    }
}
