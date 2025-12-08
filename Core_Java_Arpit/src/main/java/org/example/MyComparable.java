package org.example;

import java.util.*;

class Student4 implements Comparable<Student4> {
    String name;
    int marks;

    Student4(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    //Sorts ascending as per names if marks are same else descending as per marks
    @Override
    public int compareTo(Student4 other) {
        if (this.marks != other.marks) {
            return other.marks - this.marks;   // sort by marks first
        }
        return this.name.compareTo(other.name); // if marks same, sort by name
    }

    @Override
    public String toString() {
        return name + ": " + marks;
    }
}

public class MyComparable {
    public static void main(String[] args) {
        List<Student4> students = new ArrayList<>();
        students.add(new Student4("Alice", 85));
        students.add(new Student4("Bob", 92));
        students.add(new Student4("Charlie", 78));
        students.add(new Student4("Krish", 78));

        Collections.sort(students);

        for (Student4 s : students) {
            System.out.println(s);
        }
    }
}