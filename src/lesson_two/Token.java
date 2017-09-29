package lesson_two;

class Token {
    public final TokenType type;
    public final String text;
    public final int from; //Include
    public final int to; //Does not include

    public Token(TokenType type, String text, int from, int to) {
        this.type = type;
        this.text = text;
        this.from = from;
        this.to = to;
    }

    enum TokenType
    {
        NUMBER, PLUS, MINUS, MUL, DIV, LPAR, RPAR, SPACES
    }
}
