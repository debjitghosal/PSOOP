/*
Write a java program to implement stack operations:

a.Push b. Pop

Write a user defined exception to check whether the stack is full or
empty.
*/

/*
Flow:
 User-defined exception for stack full condition
 User-defined exception for stack empty condition
 Stack implementation using array
 then use constructor
 the use the push and pop operations 
 Main class to demonstrate stack operations
*/

import java.util.Scanner;
class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
}


class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;
    
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) throws StackFullException {
        if (top == maxSize - 1) {
            throw new StackFullException("Stack is full");
        }
        stackArray[++top] = value;
    }
    public int pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("Stack is empty");
        }
        return stackArray[top--];
    }
}

public class Push_Pop {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60);

            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());
        } catch (StackFullException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
