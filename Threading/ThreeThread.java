/*
Write a Java program that implements a multi-thread application that has three threads. First thread generates a random integer for every 1 second; second thread computes the square of the number and prints; third thread will print the value of cube of the number. 
Write unique variable names and also use tgis test case for reference. Dont make it a infinite loop.
The program should run for only three times.

Sample Output:

Random Integer generated : 82 

Square of 82 = 6724 

Cube of 82 = 551368 
*/

import java.util.Scanner;
import java.util.Random;

class RandomNumberGenerator extends Thread {
    private Random random = new Random();

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            int randomNumber = random.nextInt(100); // Generating a random integer between 0 and 99
            System.out.println("Random Integer generated: " + randomNumber);
            try {
                Thread.sleep(2000); // Sleep for 2	 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new SquareThread(randomNumber).start();
            new CubeThread(randomNumber).start();
        }
    }
}

class SquareThread extends Thread {
    private int number;

    public SquareThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Square of " + number + " = " + (number * number));
    }
}

class CubeThread extends Thread {
    private int number;

    public CubeThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + number + " = " + (number * number * number));
    }
}

public class ThreeThread {
    public static void main(String[] args) {
        new RandomNumberGenerator().start();
    }
}

