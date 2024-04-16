/*
Write a java program to throw a exception (checked) for an employee details. a) If an employee name is a number, a name exception must be thrown. b) If an employee age is greater than 50, an age exception must be thrown. c) Or else an object must be created for the entered employee details

Demonstarte different kinds of Exceptions:

1-ArithmaticException: find HCF and LCM of two no's

2- Array outofboud exception: 

3-NumberFormatException

4-StringIndexOutOfBoundsException
*/


import java.util.Scanner;

class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}

class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) throws NameException, AgeException {
        if (name.matches("[0-9]")) {
            throw new NameException("Employee name cannot contain numbers.");
        }
        if (age > 50) {
            throw new AgeException("Employee age cannot be greater than 50.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        try {
            Employee employee = new Employee(name, age);
            System.out.println("Employee details:");
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
        } catch (NameException e) {
            System.out.println("Name Exception: " + e.getMessage());
        } catch (AgeException e) {
            System.out.println("Age Exception: " + e.getMessage());
        }
    }
}

