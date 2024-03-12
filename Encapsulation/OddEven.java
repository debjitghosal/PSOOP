package Encapsulation;
/*
 Write a program using classes and objects to print all even and odd
numbers in the range of 1-100 as well as the total number of even and
odd numbers in the given range.
As an extra, the range may be inputted from the user.
Use the concept of classes and objects.
*/
/*
 Flow:
Input start and end;
Call NumFinder Constructor;
Then call odd_even method for printing no.
*/

import java.util.Scanner;
class NumberFinder
{
int start, end;
NumberFinder (int start, int end)
{
this.start = start;
this.end = end;
}
boolean checkEven (int x)
{
return (x%2==0);
}
void print ()
{
int ocount = 0;
int ecount = 0;
System.out.println ("Even numbers in the range " + start + " to " + end + ":");
for (int i = start; i <= end; i++)
{
if (checkEven(i))
{
System.out.print (i + " ");
ecount++;
}
}
System.out.println ("\nOdd numbers in the range " +
start + " to " + end + ":");
for (int i = start; i <= end; i++)
{
if (!checkEven(i))
{
System.out.print (i + " ");
ocount++;
}
}
System.out.println ("\nTotal number of even numbers in the range is: " + ecount);
System.out.println ("Total number of odd numbers in the range is: " + ocount);
}
}
class OddEven
{
public static void main (String[] args)
{
Scanner input = new Scanner (System.in);
System.out.print ("Enter the starting range: ");
int startRange = input.nextInt ();
System.out.print ("Enter the ending range: ");
int endRange = input.nextInt ();
NumberFinder a = new NumberFinder (startRange,
endRange);
a.print();
input.close ();
}
}

