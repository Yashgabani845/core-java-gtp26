package org.example;

import java.util.*;

// Define the Student class
class Student3 {
    String name;
    Integer age;

    // Constructor
    Student3(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    // Method to print student details
    @Override
    public String toString() {
        return name + " : " + age;
    }
}

public class MyComparator3 {
    public static void main(String[] args) {
        List<Student3> students = new ArrayList<>();

        students.add(new Student3("Ajay", 27));
        students.add(new Student3("Sneha", 23));
        students.add(new Student3("Simran", 37));

        // Original List
        System.out.println("Original List:");

        // Iterating List
        for (Student3 it : students) {
            System.out.println(it);
        }
        System.out.println();
        // Sort students by name, then by age
        students.sort(Comparator.comparing(Student3::getName).thenComparing(Student3::getAge));
        // Display message after sorting
        System.out.println("After Sorting:");
        // Iterating using enhanced for-loop after sorting ArrayList
        for (Student3 it : students) {
            System.out.println(it);
        }
    }
}