package lesson_two;


import lesson_three.ExprNode1;
import lesson_three.Parser;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Lexer l = new Lexer(new Scanner(new InputStreamReader(System.in)).nextLine());
        Token t;
        List<Token> tokens = new ArrayList<>();
        while ((t = l.nextToken()) != null)
        {
            tokens.add(t);
        }
        Parser p = new Parser(tokens);
        ExprNode1 n = p.parseExpression();
        System.out.println(n.toString());
    }
}
