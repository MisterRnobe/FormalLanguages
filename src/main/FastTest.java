package main;

import java.io.InputStreamReader;
import java.util.Scanner;

public class FastTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(new InputStreamReader(System.in));
        String str = s.nextLine();
        System.out.println(str.contains("\""));
    }
}
