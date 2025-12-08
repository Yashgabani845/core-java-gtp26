package org.example;

import java.util.stream.Stream;

public class StreamBasic {
    public static void main(String[] args) {
        Stream.of("Akshay", "Rahul").map(String::toUpperCase).forEach(System.out::println);
        Stream.of("raj", "lakham").filter((x) -> x.length() > 4).forEach(System.out::println);
    }


}
