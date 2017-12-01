package main.language;

import main.language.nodes.ExpressionNode;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CharStreamState;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Runner {
    public static void main(String[] args) {
        String test = "(1+2)*3";
        LangLexer lexer = new LangLexer(CharStreams.fromString(test));
        LangParser p = new LangParser(new CommonTokenStream(lexer));
        LangParser.ExprContext context = p.expr();
        ExpressionNode n = ExpressionNode.visitExpr(context);
        System.out.println(n.toString());
    }
}
