/*
Define parent class "Employee" that has 3 private attributes
String name, String id, int age.
Employee has constructor with 3 arguments that set value of name, id, age. It also has getter and setter
methods for all 3 private attributes.
Class "SalariedEmployee" is a sub class of Employee and has 1 private attribute empSalary.
"SalariedEmployee" can be permanent or on contract and has constructor SalariedEmployee(String name,
String id, int age, double empSalary) to set the values.
constructor SalariedEmployee must call the superclass constructor to set name, id, age and call setter
method to set the salary.
Employee salary is empSalary + 2000(allowance) if he is a permanent employee else Employee salary is
empSalary (no allowance).
Accept the details of 5 employees and print details of the employee with highest salary.
Create class Tester with main method
*/

import java.util.Scanner;

class Employee {
    private String name;
    private String id;
    private int age;

    public Employee(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class SalariedEmployee extends Employee {
    private double empSalary;

    public SalariedEmployee(String name, String id, int age, double empSalary) {
        super(name, id, age);
        this.empSalary = empSalary;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    // Calculate salary with allowance for permanent employees
    public double calculateSalary() {
        return (this instanceof PermanentEmployee) ? empSalary + 2000 : empSalary;
    }
}

class PermanentEmployee extends SalariedEmployee {
    public PermanentEmployee(String name, String id, int age, double empSalary) {
        super(name, id, age, empSalary);
    }
}

class ContractEmployee extends SalariedEmployee {
    public ContractEmployee(String name, String id, int age, double empSalary) {
        super(name, id, age, empSalary);
    }
}

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalariedEmployee[] employees = new SalariedEmployee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for employee " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Is the employee permanent? (yes/no): ");
            String permanent = scanner.nextLine().toLowerCase();

            if (permanent.equals("yes")) {
                employees[i] = new PermanentEmployee(name, id, age, salary);
            } else {
                employees[i] = new ContractEmployee(name, id, age, salary);
            }
        }

        // Finding employee with highest salary
        SalariedEmployee highestPaidEmployee = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].calculateSalary() > highestPaidEmployee.calculateSalary()) {
                highestPaidEmployee = employees[i];
            }
        }
		System.out.println("  ");
        System.out.println("Employee with highest salary:");
        System.out.println("Name: " + highestPaidEmployee.getName());
        System.out.println("ID: " + highestPaidEmployee.getId());
        System.out.println("Age: " + highestPaidEmployee.getAge());
        System.out.println("Salary: " + highestPaidEmployee.calculateSalary());
    }
}

