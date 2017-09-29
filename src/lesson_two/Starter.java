package lesson_two;


import java.io.InputStreamReader;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Lexer l = new Lexer(new Scanner(new InputStreamReader(System.in)).nextLine());
        Token t;
        while ((t = l.nextToken()) != null)
        {
            System.out.println(t.type+": "+t.text);
        }
    }
}
