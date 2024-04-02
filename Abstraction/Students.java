/*
Problem Statement#: Student Details Program

Write an abstract class Course with an abstract method studentDetails().

Create 2 classes Comps and IT which inherits class Course and implements studentDetails().

The studentDetails() method should print the name, UID, and year (FE, SE, TE) of students of that Course. 
These details have to be taken from the user. 
Write a program that asks user to choose a course  and print the details of all students in that course in a sorted manner  
as per the year( FE,SE,TE)\
*/


import java.util.*;

abstract class Course {
    abstract void studentDetails();
}

class Comps extends Course {
    private List<Student> students = new ArrayList<>();

    @Override
    void studentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students for COMPS course:");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.println("Enter UID of student " + (i + 1) + ":");
            int uid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter year (FE, SE, TE) of the student " + (i + 1) + ":");
            String year = scanner.nextLine();
            students.add(new Student(name, uid, year));
        }
        students.sort(Comparator.comparing(Student::getYear));
        System.out.println("\nStudent details for COMPS course:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class IT extends Course {
    private List<Student> students = new ArrayList<>();

    @Override
    void studentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students for IT course:");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.println("Enter UID of student " + (i + 1) + ":");
            int uid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter year (FE, SE, TE) of the student " + (i + 1) + ":");
            String year = scanner.nextLine();
            students.add(new Student(name, uid, year));
        }
        students.sort(Comparator.comparing(Student::getYear));
        System.out.println("\nStudent details for IT course:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    private String name;
    private int uid;
    private String year;

    public Student(String name, int uid, String year) {
        this.name = name;
        this.uid = uid;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", UID: " + uid + ", Year: " + year;
    }
}

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a course:\n1. Computer Engeneering (CE)\n2. Information Technology (IT)");
        int choice = scanner.nextInt();
        Course course;
        switch (choice) {
            case 1:
                course = new Comps();
                break;
            case 2:
                course = new IT();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        course.studentDetails();
    }
}

