package main;

import main.language.types.AbstractType;
import main.language.types.IntegerType;
import main.language.types.VoidType;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FastTest {
    public static void main(String[] args) {
        Supplier[] suppliers = new Supplier[11];
        for (int i = 0; i < 11; i++) {
            int j = i;
            suppliers[i] = () -> print(j);
        }
        suppliers[4] = () -> print(2.d);
        //Object object = Arrays.stream(suppliers).map(Supplier::get).filter(o -> o.getClass() == Double.class).findFirst().get();
        try {
            Arrays.stream(suppliers).forEach(Supplier::get);
        }
        catch (RuntimeException e)
        {
            System.err.println(e.getMessage());
        }
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
