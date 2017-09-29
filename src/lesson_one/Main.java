package lesson_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static Scanner number = new NumberScanner();
    public static Scanner symbol = new SymbolScanner();
    public static Scanner scanner = symbol;
    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();

        for (int i = 0; i < s.length(); i++) {
            boolean b = scanner.scan(s.charAt(i));
            if (b)
            {
                i--;
                changeScanner();
            }
        }
        if (scanner == number)
            scanner.scan('\0');
        for (Integer i: list) {
            System.out.print(i+" ");
        }
    }
    public static class NumberScanner implements Scanner
    {
        int number;
        NumberScanner()
        {
            number = 0;
        }
        @Override
        public boolean scan(char ch) {
           if (isNumber(ch))
           {
               number = number * 10 + (ch-'0');
               return false;
           }
           else
           {
               list.addLast(number);
               number = 0;
               return true;
           }
        }
    }

    public static class SymbolScanner implements Scanner
    {

        @Override
        public boolean scan(char ch) {
            return isNumber(ch);

        }
    }
    public static boolean isNumber(char ch)
    {
        return ch >= '0' && ch <= '9';
    }
    public static void changeScanner()
    {
        scanner = scanner == number? symbol:number;
    }
}