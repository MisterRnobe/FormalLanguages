package lesson_four;

import lesson_three.ExprNode1;
import lesson_two.Lexer;
import lesson_two.ParseException;
import lesson_two.Token;
import lesson_two.Token.TokenType;

import java.util.List;

/**
 * Выражение = слагаемое((+|-)слагаемое)*
 * Слагаемое = Множитель((*|/)множитель)*
 * Множитель = Число|'('выражение')'|унарный_оператор|
 * Унарный_оператор = Число|'('выражение')'
 */

public class Parser5 {
    /**
     * Список лексем
     */
    private final List<Token> tokens;
    /**
     * Индекс текущей лексемы
     */
    private int index = 0;

    public Parser5(List<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * Проверка типа текущей лексемы.
     *
     * @param type предполагаемый тип лексемы
     * @return не null, если текущая лексема предполагаемого типа (при этом текущи индекс сдвигается на 1);
     * null, если текущая лексема другого типа
     */
    private Token match(TokenType type) {
        if (index >= tokens.size())
            return null;
        Token token = tokens.get(index);
        if (token.type != type)
            return null;
        index++;
        return token;
    }

    /**
     * Сообщение об ошибке с указанием текущей позиции в тексте.
     *
     * @param message текст сообщения
     */
    private void error(String message) throws ParseException {
        // Позиция ошибки в тексте
        int errorPosition;
        if (index >= tokens.size()) {
            // Мы стоим в конце текста
            if (tokens.isEmpty()) {
                // Лексем не было вообще - текст пустой; указываем на начало текста
                errorPosition = 0;
            } else {
                // Берем координату после последней лексемы
                errorPosition = tokens.get(tokens.size() - 1).to;
            }
        } else {
            // Берем координату текущей лексемы
            Token token = tokens.get(index);
            errorPosition = token.from;
        }
        throw new ParseException(message, errorPosition);
    }

    /**
     * Метод для нетерминального символа 'слагаемое'.
     *
     * Слагаемое = Множитель((*|/)множитель)*
     *
     * @return узел дерева, соответствующий слагаемому
     */
    private ExprNode1 matchTerm() throws ParseException
    {
        ExprNode1 leftNode = matchFactor();
        //Пока есть * или /
        while (true) {
            Token op = matchAny(Token.TokenType.DIV, Token.TokenType.MUL);
            if (op != null) {
                // Требуем после * или / снова множитель:
                ExprNode1 rightNode = matchFactor();
                // Из двух слагаемых формируем дерево с двумя поддеревьями:
                leftNode = new ExprNode1(leftNode, rightNode, op);
            } else {
                break;
            }
        }
        return leftNode;
    }
    private ExprNode1 mathNumberOrExpression() throws ParseException
    {
        Token number = match(Token.TokenType.NUMBER);
        if (number != null) {
            // Если это ЧИСЛО, то возвращаем узел для числа:
            return new ExprNode1(number);
        }
        if (match(Token.TokenType.LPAR) != null) {
            // Если это открывающая скобка, то вызываем разбор выражения в скобках:
            ExprNode1 nested = matchExpression();
            // После него обязательно должна быть закрывающая скобка:
            if (match(Token.TokenType.RPAR) == null) {
                error("Missing ')'");
            }
            return nested;
        } else {
            // Иначе ошибка - других вариантов кроме числа и скобки быть не может:
            error("Number or '(' expected");
            return null;
        }
    }

    /**
     * Проверка типа текущей лексемы.
     *
     * @param types возможные типы лексем
     * @return не null, если текущая лексема одного из предполагаемых типов (при этом текущи индекс сдвигается на 1);
     * null, если текущая лексема другого типа
     */
    private Token matchAny(Token.TokenType... types) {
        for (Token.TokenType type : types) {
            Token matched = match(type);
            if (matched != null)
                return matched;
        }
        return null;
    }

    /**
     * Грамматический разбор выражения по грамматике
     * выражение ::= слагаемое (('+'|'-') слагаемое)*
     *
     * @return дерево разбора выражения
     */
    public ExprNode1 matchExpression() throws ParseException {
        // В начале должно быть слагаемое:
        ExprNode1 leftNode = matchTerm();
        while (true) {
            // Пока есть символ '+' или '-'...
            Token op = matchAny(Token.TokenType.PLUS, Token.TokenType.MINUS);
            if (op != null) {
                // Требуем после плюса/минуса снова слагаемое:
                ExprNode1 rightNode = matchTerm();
                // Из двух слагаемых формируем дерево с двумя поддеревьями:
                leftNode = new ExprNode1(leftNode, rightNode, op);
            } else {
                break;
            }
        }
        return leftNode;
    }

    /**
     *
     * @return
     */
    public ExprNode1 matchUnary() throws ParseException
    {
        return mathNumberOrExpression();
    }

    /**
     * Множитель = Число|'('выражение')'
     * @return дерево разбора выражений
     * @throws ParseException ошибка разбора
     */

    public ExprNode1 matchFactor() throws ParseException
    {
        Token t = match(TokenType.LN);
        if (t != null)
        {
            return new ExprNode1(mathNumberOrExpression(), t);
        }
        else
            return mathNumberOrExpression();

    }
    /**
     * Проверка грамматического разбора выражения
     */
    public static void main(String[] args) throws ParseException {
        String expression = "LN(2*LN(2)) - 2";
        Lexer lexer = new Lexer(expression);
        List<Token> allTokens = lexer.getAllTokens();
        Parser5 parser = new Parser5(allTokens);
        for (Token t: allTokens) {
            System.out.println(t.type+" "+t.text);
        }
        ExprNode1 exprTreeRoot = parser.matchExpression();
        System.out.println(exprTreeRoot.toString()+" = "+exprTreeRoot.compute());
        System.out.println(exprTreeRoot.toString());

    }
}
