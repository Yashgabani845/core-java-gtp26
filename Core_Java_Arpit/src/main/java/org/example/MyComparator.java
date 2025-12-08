package org.example;

import java.util.*;

// Define the Student class
class Student{

    int rollno;
    String name;

    Student(int rollno, String name){

        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public String toString(){

        return rollno + ": " + name;
    }
}

// Helper class implementing Comparator interface
class SortByRollAsc implements Comparator<Student>{

    public int compare(Student a, Student b) {
        return a.rollno - b.rollno; // Ascending order
    }
}

class SortByRollDesc implements Comparator<Student>{

    public int compare(Student a, Student b) {
        return b.rollno - a.rollno; // Ascending order
    }
}

// Driver class
public class MyComparator{

    public static void main(String[] args){

        List<Student> students = new ArrayList<>();
        students.add(new Student(111, "Mayank"));
        students.add(new Student(131, "Anshul"));
        students.add(new Student(121, "Solanki"));
        students.add(new Student(101, "Aggarwal"));

        // Sort students by roll number
        Collections.sort(students, new SortByRollAsc());

        System.out.println("Sorted by Roll Number in Ascending order:");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students, new SortByRollDesc());

        System.out.println("Sorted by Roll Number in Descending order:");
        for (Student s : students) {
            System.out.println(s);
        }

    }
}