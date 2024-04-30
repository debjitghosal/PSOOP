/*
 You are given an interface Arithmetic which contains a method signature int divisor_sum(int n). 
 You need to write a class called MyCalculator which implements the interface.
divisorSum function just takes an integer as input and return the sum of all its divisors. 

For example divisors of 6 are 1, 2, 3 and 6, so divisor_sum should return 12. The value of n will be at most 1000.
*/

import java.util.Scanner;

interface Arithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements Arithmetic {
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class FinalDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (<= 1000): ");
        int n = scanner.nextInt();

        MyCalculator myCalculator = new MyCalculator();
        System.out.println("Divisor sum of " + n + ": " + myCalculator.divisor_sum(n));

        scanner.close();
    }
}

