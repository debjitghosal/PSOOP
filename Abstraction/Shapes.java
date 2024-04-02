/* Problem Statement: Shape Program

Write a program to calculate the area of 4 rectangles, 5 squares and  2 circles. 

Create an abstract class 'Shape' with three abstract methods namely 'RectangleArea' taking two parameters, 'SquareArea' and 'CircleArea' taking one parameter each. 

The parameters of 'RectangleArea' are its length and breadth, that of 'SquareArea' is its side and that of 'CircleArea' is its radius.

Now create another class 'Area' containing all the three methods 'RectangleArea', 'SquareArea' and 'CircleArea' for printing the area of rectangle, square and circle respectively. 

Create an object of class 'Area' and call all the three methods.*/

import java.util.Scanner;

abstract class Shape {
   
    abstract double RectangleArea(double length, double breadth);
    abstract double SquareArea(double side);
    abstract double CircleArea(double radius);
}

class Area extends Shape {
    
    @Override
    double RectangleArea(double length, double breadth) {
        return length * breadth;
    }

    @Override
    double SquareArea(double side) {
        return side * side;
    }

    @Override
    double CircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}


public class Shapes{
    public static void main(String[] args){
     Area area = new Area();

      
        System.out.println("Area of 4 rectangles:");
        System.out.println("Rectangle 1: " + area.RectangleArea(5, 10));
        System.out.println("Rectangle 2: " + area.RectangleArea(7, 8));
        System.out.println("Rectangle 3: " + area.RectangleArea(17, 3));
        System.out.println("Rectangle 4: " + area.RectangleArea(4, 9));
        
        System.out.println("\nArea of 5 squares:");
        System.out.println("Square 1: " + area.SquareArea(4));
        System.out.println("Square 2: " + area.SquareArea(8));
        System.out.println("Square 3: " + area.SquareArea(7));
        System.out.println("Square 4: " + area.SquareArea(3));
        System.out.println("Square 5: " + area.SquareArea(5));
        
        System.out.println("\nArea of 2 Circle:");
        System.out.println("Cicle 1: " + area.CircleArea(10));
        System.out.println("Cicle 1: " + area.CircleArea(20));
        
        }
     }
        
        
        
        
        
    

   


