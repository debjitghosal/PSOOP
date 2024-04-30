/*
Program on Inheritance: Implement a Program to demonstrate multiple Inheritance

Write a program to maintain marks of student.
 i) Student is Abstract class and it has Roll no., Name, subjectmark attributes. Showstudentdata() is abstract method. 
 Getstudentdata() is non abstract method. 
ii) ISport is an Interface, having attribute sportgracemarks=5. Showsportmark() is a method. 
iii) IExServiceMan is an Interface, having attribute ExServiceMangracemarks=10. ShowExServiceManmark() is a method.
 iv) Result is Class and it is inheriting Student, ISport, IExServiceMan. 
 Totalmarks=subjectmark + sportgracemarks +ExServiceMangracemarks. Showresult() is method of Result class.
*/

import java.util.Scanner;
// part 1
abstract class Student {
    protected int rollNo;
    protected String name;
    protected int subjectMarks;

    public abstract void showStudentData();

    public void getStudentData(int rollNo, String name, int subjectMarks) {
        this.rollNo = rollNo;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }
}
// part 2
interface ISport {
    int sportGraceMarks = 5;

    void showSportMark();
}
// part 3
interface IExServiceMan {
    int exServiceManGraceMarks = 10;

    void showExServiceManMark();
}
// part 4a
class Result extends Student implements ISport, IExServiceMan {
    private int totalMarks;

    public void calculateTotalMarks() {
        totalMarks = subjectMarks + sportGraceMarks + exServiceManGraceMarks;
    }
// part 4b(Creating method of Result class)
    public void showResult() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Subject Marks: " + subjectMarks);
        System.out.println("Sport Grace Marks: " + sportGraceMarks);
        System.out.println("Ex-Service Man Grace Marks: " + exServiceManGraceMarks);
        System.out.println("Total Marks: " + totalMarks);
    }

    @Override
    public void showStudentData() {
        System.out.println("Student Data:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Subject Marks: " + subjectMarks);
    }

    @Override
    public void showSportMark() {
        System.out.println("Sport Grace Marks: " + sportGraceMarks);
    }

    @Override
    public void showExServiceManMark() {
        System.out.println("Ex-Service Man Grace Marks: " + exServiceManGraceMarks);
    }
}

public class FinalResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Roll No:");
        int rollNo = scanner.nextInt();

        System.out.println("Enter Name:");
        String name = scanner.next();

        System.out.println("Enter Subject Marks:");
        int subjectMarks = scanner.nextInt();

        Result student1 = new Result();
        student1.getStudentData(rollNo, name, subjectMarks);
        student1.calculateTotalMarks();
        student1.showResult();

        scanner.close();
    }
}

