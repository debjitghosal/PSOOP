/*
Write a program to calculate the percentage of marks obtained in three subjects
(each out of 100) by student A and in four subjects (each out of 100) by student B.
Create an abstract class 'Marks' with an abstract method 'getPercentage'.

It is inherited by two other classes 'A' and 'B' each having a method with the same name
which returns the percentage of the students. The constructor of student A takes the marks in three subjects
as its parameters and the marks in four subjects as its parameters for student B. Input to be taken
from the user. Display the marks in highest order of student A and B.
 */

import java.util.Scanner;

abstract class Marks {
	abstract double getPercentage();
}

class A extends Marks {
	int sub1;
	int sub2;
	int sub3;

	public A(int sub1, int sub2, int sub3) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}

	@Override
	double getPercentage() {
		int sum = sub1 + sub2 + sub3;
		return (double) (sum * 100) / 300;
	}
}


class B extends Marks {
    int sub1;
    int sub2;
    int sub3;
    int sub4;
        
    public B (int sub1, int sub2, int sub3, int sub4) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
    }
                
    @Override
    double getPercentage() {
            int sum = sub1 + sub2 + sub3 + sub4;
            return (double) (sum * 100) / 400;
    }
}

public class Marksheet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter marks for A: ");
        System.out.print("Sub1: ");
        int sub1 = in.nextInt();
        System.out.print("Sub2: ");
        int sub2 = in.nextInt();
        System.out.print("Sub3: ");
        int sub3 = in.nextInt();


        A a = new A(sub1, sub2, sub3);
        System.out.println("Percentage of A is: " + a.getPercentage());

        System.out.println("Enter marks for B: ");
        System.out.print("Sub1: ");
        sub1 = in.nextInt();
        System.out.print("Sub2: ");
        sub2 = in.nextInt();
        System.out.print("Sub3: ");
        sub3 = in.nextInt();
        System.out.print("Sub4: ");
        int sub4 = in.nextInt();

        B b = new B(sub1, sub2, sub3, sub4);
        System.out.println("Percentage of B is: " + b.getPercentage());

    }
}
