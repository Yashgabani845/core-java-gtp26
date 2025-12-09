package org.example;

import java.util.*;
import java.util.stream.Stream;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " ($" + salary + ")";
    }
}

public class MyStream {

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {

        // 1️⃣ STREAM FROM ARRAY
        System.out.println("Stream from array:");
        Stream<Employee> streamFromArray = Stream.of(arrayOfEmps);
        streamFromArray.forEach(System.out::println);

        // 2️⃣ STREAM FROM LIST
        System.out.println("\nStream from List:");
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream().forEach(System.out::println);

        // 3️⃣ STREAM FROM INDIVIDUAL OBJECTS
        System.out.println("\nStream from individual objects:");
        Stream<Employee> streamOfObjects = Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
        streamOfObjects.forEach(System.out::println);

        // 4️⃣ STREAM USING Stream.builder()
        System.out.println("\nStream using Stream.builder():");
        Stream.Builder<Employee> empBuilder = Stream.builder();

        empBuilder.accept(arrayOfEmps[0]);
        empBuilder.accept(arrayOfEmps[1]);
        empBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> builtStream = empBuilder.build();
        builtStream.forEach(System.out::println);

        // 5️⃣ BONUS: Meaningful Operation (Filter high salary)
        System.out.println("\nEmployees with salary > 150000:");
        empList.stream()
                .filter(emp -> emp.salary > 150000)
                .forEach(System.out::println);
    }
}
