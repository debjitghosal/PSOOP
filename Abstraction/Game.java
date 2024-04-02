/*Program 2: 
The task is to write a Java program in which a user will get K trials
to guess a randomly generated number. Below are the rules of the game:
If the guessed number is bigger than the actual number, the program will respond with the message 
that the guessed number is higher than the actual number.
If the guessed number is smaller than the actual number, the program will respond with the message
that the guessed number is lower than the actual number.
If the guessed number is equal to the actual number or if the K trials are exhausted, 
the program will end with a suitable message.

Approach: Below are the steps:
The approach is to generate a random number using Math.random() method in Java.
Now using a loop, take K input from the user and for each input print whether the number is smaller
 or larger than the actual number.
If within K trials the user guessed the number correctly, print that the user won.
Else print that he was not able to guess and then print the actual number.
Define the Player class with a abstract function named getGuess().
*/
import java.util.Scanner;

abstract class Player{
    int k;
    abstract void getGuess();

}

class User extends Player{
    static int max = 100;
    static int min = 1;
    static int range = max - min + 1;
    int chances = 5;
    int current = 0;

    Scanner in = new Scanner(System.in);
    static int number = (int)(Math.random()*range) + min;
    void getGuess(){

        for ( int current = 0; current < chances; current++ ) {

            System.out.println("Guess the number between 1 and 100");
            k = in.nextInt();

            if (k == number)
            {
                System.out.println("You've Guessed the number. Congratulations!");
                break;
            }
            else if(k>number)
                System.out.println("Your number is higher. Attempts Remaining: " + (chances - current - 1));
             else if (k < number)
                System.out.println("Your number is lower. Attempts Remaining: " + (chances - current - 1));
            }
        if (chances == current)
            System.out.println("No Attempts Remaining // Game Over //");
        }

    }


public class Game{
    public static void main(String[] args) {

        User u1 = new User();
        u1.getGuess();
    }


}
