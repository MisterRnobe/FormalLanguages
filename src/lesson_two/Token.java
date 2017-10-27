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
    private static double fac(double x)
    {
        if (x < 0)
            return x;
        double i = 1;
        for (int k = 1; k < x; k++, i*=k);
        return i;
    }

    public static void main(String[] args) {
        System.out.println(fac(8.5));
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

            @Override
            public boolean isOperator() {
                return false;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return false;
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
            @Override
            public boolean isOperator() {
                return false;
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
            @Override
            public boolean isOperator() {
                return false;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return true;
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
            @Override
            public boolean isOperator() {
                return true;
            }
    },
        NEG{
            @Override
            public double compute(double... d) {
                return -d[0];
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("~"));
            }
            @Override
            public boolean isOperator() {
                return true;
            }
        },
        EXP{
            @Override
            public double compute(double... d) {
                return Math.exp(d[0]);
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("EXP"));
            }

            @Override
            public boolean isOperator() {
                return true;
            }
        },
        POW {
            @Override
            public double compute(double... d) {
                return Math.pow(d[0],d[1]);
            }

            @Override
            public Pattern pattern() {
                return Pattern.compile(Pattern.quote("^"));
            }

            @Override
            public boolean isOperator() {
                return true;
            }
        },
        FAC {
            @Override
            public double compute(double... d) {
                return fac(d[0]);
            }

            @Override
            public Pattern pattern() {
                return null;
            }

            @Override
            public boolean isOperator() {
                return false;
            }
        };

        public abstract double compute(double... d);
        public abstract Pattern pattern();
        public abstract boolean isOperator();
    }
}
