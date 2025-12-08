package org.example;

import java.util.*;

// Define the Student class
class Student2{

    String name;
    Integer age;

    Student2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}

// Comparator for multiple fields
class StudentComparator implements Comparator<Student2>{

    public int compare(Student2 s1, Student2 s2) {
        int nameCompare = s1.getName().compareTo(s2.getName());
        int ageCompare = s1.getAge().compareTo(s2.getAge());
        return (nameCompare == 0) ? ageCompare : nameCompare;
    }
}

public class MyComparator2{
    public static void main(String[] args) {
        List<Student2> students = new ArrayList<>();
        students.add(new Student2("Ajay", 27));
        students.add(new Student2("Sneha", 23));
        students.add(new Student2("Simran", 37));
        System.out.println("Original List:");
        for (Student2 s : students) {
            System.out.println(s);
        }
        // Sort by name, then by age
        Collections.sort(students, new StudentComparator());
        System.out.println("\nAfter Sorting:");
        for (Student2 s : students) {
            System.out.println(s);
        }
    }
}