package lesson_two;

import java.util.regex.Pattern;

public class Token {
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

    public enum TokenType
    {
        NUMBER{
            @Override
            public double compute(double... d) {
                return 0;
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile("\\d+[.]?\\d*");
            }

        },
        PLUS {
            @Override
            public double compute(double... d) {
                return d[0]+d[1];
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("+"));
            }
        },
        MINUS {
        @Override
            public double compute(double... d) {
                return d[0]-d[1];
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("-"));
            }
        },
        MUL {
            @Override
            public double compute(double... d) {
                return d[0]*d[1];
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("*"));
            }
        },
        DIV {
            @Override
            public double compute(double... d) {
                return d[0]/d[1];
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("/"));
            }
        },
        LPAR {
        @Override
        public double compute(double... d) {
            return 0;
        }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("("));
            }
        },
        RPAR {
        @Override
        public double compute(double... d) {
            return 0;
        }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote(")"));
            }
        },
        SPACES {
        @Override
        public double compute(double... d) {
            return 0;
        }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote(" "));
            }
        },
        LN {
        @Override
        public double compute(double... d) {
            return Math.log(d[0]);
        }

            @Override
            public Pattern pattern() {
                return Pattern.compile("LN");
            }
        },
        SIN {
        @Override
        public double compute(double... d) {
            return Math.sin(d[0]);
        }
            @Override
            public Pattern pattern() {
                return Pattern.compile("SIN");
            }
    },
        COS {
        @Override
        public double compute(double... d) {
            return Math.cos(d[0]);
        }
            @Override
            public Pattern pattern() {
                return Pattern.compile("COS");
            }
    };

        public abstract double compute(double... d);
        public abstract Pattern pattern();
    }
}
