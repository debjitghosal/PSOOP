/*
 Write a program to print all Armstrong numbers in the range inputted
by the user. Also print the total count of Armstrong numbers in the
range.
Use the concept of classes and objects.
*/

package Encapsulation;

import java.util.Scanner;
import java.lang.*;
class NumberFinder
{
int start, end;
NumberFinder (int start, int end)
{
this.start = start;
this.end = end;
}
int Digit (int x)
{
int dig = 0;
while (x!=0)
{
x/=10;
dig++;
}
return dig;
}
int checkArmstrong (int x)
{
int d,s=0,t=x;
while (x!=0)
{
d = x%10;
s+=Math.pow (d,Digit(t));
x/=10;
}
if (s==t)
return 1;
else
return 0;
}
void print ()
{
int acount = 0;
System.out.println ("Armstrong numbers in the range " +
start + " to " + end + ":");
for (int i = start; i <= end; i++)
{
if (checkArmstrong(i)==1)
{
System.out.print (i + " ");
acount++;
}
}
System.out.println ("\nTotal number of Armstrong numbers in the range is: " + acount);
}
}
class Armstrong
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
