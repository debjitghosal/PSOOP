/*
Write a java program to print "Welcome to SPIT" and "Computer Engineering Department" continuously on the screen in Java using threads. Add a sleep method in the welcome thread to delay its execution for 200ms.
Also use can use wait(), notify() operators.
*/
/*
Flow:
extend a class
again extend second class
we use synchronized class for  a proper output in a proper order
create a void method
create the main method
*/
import java.util.Scanner;
class WelcomeThread extends Thread {
    private final Object lock;

    public WelcomeThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    System.out.println("Welcome to SPIT");
                    lock.notify();
                    lock.wait(500); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DepartmentThread extends Thread {
    private final Object lock;
    public DepartmentThread(Object lock) {
        this.lock = lock;
    }
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Computer Engineering Department");
            }
        }
    }
}

public class Thread2 {
    public static void main(String[] args) {
        Object lock = new Object();

        WelcomeThread welcomeThread = new WelcomeThread(lock);
        DepartmentThread departmentThread = new DepartmentThread(lock);

        welcomeThread.start();
        departmentThread.start();
    }
}


























