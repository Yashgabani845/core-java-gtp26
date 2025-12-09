package org.example;

import java.util.function.*;

public class Lambda_Demo {
    public static void main(String[] args) {
        Predicate<Integer> isOdd= n -> n%2==1;

        System.out.println(isOdd.test(5));

        Function<String,Integer> calLength = S -> S.length();

        System.out.println(calLength.apply("Hello g"));
    }
}
