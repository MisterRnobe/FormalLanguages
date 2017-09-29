package lesson_two;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Lexer {
    private final String str;
    private int index = 0;

    Lexer(String str)
    {
        this.str = str;
    }
    Token nextToken()//May return null
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
    private Token matchAnyToken()
    {
        if (index >= str.length())
            return null;
        Token token;
        if ((token = matchSpace()) != null)
            return token;
        if ((token = matchAnySymbol())!= null)
            return token;
        if ((token = matchNumber()) != null)
            return token;
        return null;
    }
    private int match(Pattern pattern)
    {
        Matcher m = pattern.matcher(str);
        m.region(index, str.length());
        return m.lookingAt()? m.end(): -1;
    }
    private Token matchNumber()
    {
        Pattern p = Pattern.compile("[0-9]+");
        int matched = match(p);
        return matched<0? null: new Token(Token.TokenType.NUMBER, str.substring(index, matched), index, matched);
    }
    private Token matchPlus()
    {
        Pattern p = Pattern.compile(Pattern.quote("+"));
        int matched = match(p);
        return matched<0? null: new Token(Token.TokenType.PLUS, str.substring(index,matched),index,matched);
    }

    private final Map<String, Token.TokenType> SYMBOL_MAP = new TreeMap<>();
    {
        SYMBOL_MAP.put("+", Token.TokenType.PLUS);
        SYMBOL_MAP.put("-", Token.TokenType.MINUS);
        SYMBOL_MAP.put("*", Token.TokenType.MUL);
        SYMBOL_MAP.put("/", Token.TokenType.DIV);
        SYMBOL_MAP.put("(", Token.TokenType.LPAR);
        SYMBOL_MAP.put(")", Token.TokenType.RPAR);
    }

    private Token matchAnySymbol()
    {
        for(Map.Entry<String, Token.TokenType> entry: SYMBOL_MAP.entrySet())
        {
            String key = entry.getKey();
            Token.TokenType value = entry.getValue();
            Pattern symbolPattern = Pattern.compile(Pattern.quote(key));
            int matched = match(symbolPattern);
            if (matched< 0)
                continue;
            String symbolText = str.substring(index, matched);
            return new Token(value, symbolText, index, matched);
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
