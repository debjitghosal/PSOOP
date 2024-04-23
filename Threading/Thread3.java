/*
Write a java program to print even numbers by one thread and odd numbers by another thread and 
print the sum of even and odd numbers by third thread. 
Use the Thread control function and its method (atleast one)
*/

import java.util.Scanner;

class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SumThread extends Thread {
    private int sum;

    public void run() {
        sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum Thread: Sum of numbers from 1 to 10 is " + sum);
    }
}

public class Thread3 {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        SumThread sumThread = new SumThread();

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sumThread.start();
    }
}

