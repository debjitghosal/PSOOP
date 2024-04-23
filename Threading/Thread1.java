/*
Write a Java program to perform a runnable interface, take two threads t1 and t2 and fetch the 
names of the thread using getName() method.

Sample Output:
Thread names are following:
Thread A
Thread B
*/

class ThreadExample1 extends Thread implements Runnable {
    public void run() {
        System.out.println("Thread A");
    }
}


class ThreadExample2 implements Runnable {
    public void run() {
        System.out.println("Thread B");
    }
}
public class Thread1 {
    public static void main(String[] args) {
        Runnable ex1 = new ThreadExample1();
        Runnable ex2 = new ThreadExample2();

        Thread t1 = new Thread(ex1);
        Thread t2 = new Thread(ex2);

        t1.start();
        t2.start();
    }
    
}