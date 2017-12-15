package main;

import main.language.types.AbstractType;
import main.language.types.IntegerType;
import main.language.types.VoidType;

import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FastTest {
    public static void main(String[] args) {
        String[] s = new String[]{"a","b", "c"};
        String f = "d";
        Stream.concat(Stream.of(s), Stream.of(f)).forEach(System.out::print);
    }
    public static int print(Integer num)
    {
        System.out.println(num);
        return num;
    }
    public static double print(Double num) throws RuntimeException {
        System.out.println(num);
        throw new RuntimeException("abc");
    }
}
