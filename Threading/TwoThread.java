/*
Write a java program for two-threaded program, where one thread finds all prime numbers (in 0 to 100) and another thread finds all palindrome numbers (in 10 to 1000). Schedule these threads in a sequential manner to get the results. Now reschedule them as parallel threads.Write a java code with proper class names and keep the variable names unique 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class PrimeFinder extends Thread {
    private List<Integer> primeNumbers = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class PalindromeFinder extends Thread {
    private List<Integer> palindromeNumbers = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 10; i <= 1000; i++) {
            if (isPalindrome(i)) {
                palindromeNumbers.add(i);
            }
        }
    }

    public List<Integer> getPalindromeNumbers() {
        return palindromeNumbers;
    }

    private boolean isPalindrome(int num) {
        int temp = num;
        int reverse = 0;
        while (temp != 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        return num == reverse;
    }
}

public class TwoThread {
    public static void main(String[] args) {
        // Sequential Execution
        PrimeFinder primeFinder = new PrimeFinder();
        PalindromeFinder palindromeFinder = new PalindromeFinder();

        primeFinder.start();
        try {
            primeFinder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        palindromeFinder.start();
        try {
            palindromeFinder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The Sequential Prime Numbers: " + primeFinder.getPrimeNumbers());
        System.out.println("The Sequential Palindrome Numbers: " + palindromeFinder.getPalindromeNumbers());

        // Parallel Execution
        PrimeFinder parallelPrimeFinder = new PrimeFinder();
        PalindromeFinder parallelPalindromeFinder = new PalindromeFinder();

        parallelPrimeFinder.start();
        parallelPalindromeFinder.start();

        try {
            parallelPrimeFinder.join();
            parallelPalindromeFinder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        }

