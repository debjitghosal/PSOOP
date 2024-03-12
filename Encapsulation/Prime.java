/*
 Write a program to find all prime numbers in the given range. Print
the prime numbers and total number of prime numbers in the range.
Use the concept of class and objects
*/

package Encapsulation;

import java.util.Scanner;
class NumberFinder
{
int start, end;
NumberFinder (int start, int end)
{
this.start = start;
this.end = end;
}
int checkPrime (int x)
{
int c = 0;
if (x==1)
return 1;
else
{
for (int i = 2; i < x; i++)
{
if (x%i==0)
c++;
}
return c;
}
}
void print ()
{
int pcount = 0;
System.out.println ("Prime numbers in the range " + start + " to " + end + ":");
for (int i = start; i <= end; i++)
{
if (checkPrime(i)==0)
{
System.out.print (i + " ");
pcount++;
}
}
System.out.println ("\nTotal number of prime numbers in the range is: " + pcount);
}
}
class Prime
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