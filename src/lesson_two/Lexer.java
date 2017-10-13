package lesson_two;

import java.util.*;

import lesson_two.Token.TokenType;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lexer {
    private final String str;
    private int index = 0;

    public Lexer(String str)
    {
        this.str = str;
    }
    public Token nextToken()
    {
        while (true)
        {
            Token t = matchAnyToken();
            if (t == null)
                return null;
            index = t.to;
            if (t.type!= Token.TokenType.SPACES)
                return t;
        }
    }
    public List<Token> getAllTokens()
    {
        List<Token> list = new LinkedList<>();
        Token t;
        while ((t = nextToken()) != null)
        {
            list.add(t);
        }
        return list;
    }
    private Token matchAnyToken() throws ParseException
    {
        if (index >= str.length())
            return null;
        Token token;
        if ((token = matchSpace()) != null)
            return token;
        if ((token = matchNumber())!= null)
            return token;
        if ((token = matchAnySymbol()) != null)
            return token;
        throw new ParseException("Symbol not found in " + (index+1)+" position!");
    }
    private int match(Pattern pattern)
    {
        Matcher m = pattern.matcher(str);
        m.region(index, str.length());
        return m.lookingAt()? m.end(): -1;
    }
    private Token matchNumber()
    {
        Pattern p = Pattern.compile("\\d+[.]?\\d*");
        int matched = match(p);
        return matched<0? null: new Token(Token.TokenType.NUMBER, str.substring(index, matched), index, matched);
    }

    private LinkedList<TokenType> SYMBOLS = new LinkedList<>();
    {
        SYMBOLS = new LinkedList<>(Arrays.asList(TokenType.values()));

    }

    private Token matchAnySymbol()
    {
        for(TokenType t: SYMBOLS)
        {
            int matched = match(t.pattern());
            if (matched< 0)
                continue;
            String symbolText = str.substring(index, matched);
            return new Token(t, symbolText, index, matched);
        }
        return null;
    }
    private Token matchSpace()
    {
        int i = index;
        while (i < str.length())
        {
            char ch = str.charAt(i);
            if (ch<= ' ')
            {
                i++;
            }
            else
                break;
        }
        if (i > index)
        {
            String spaces = str.substring(index, i);
            return new Token(Token.TokenType.SPACES,spaces, index, i);
        }
        else
            return null;
    }
}
