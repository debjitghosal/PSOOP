package Encapsulation;
import java.util.*;

class posting
{
  int apt;
  int course;
  int tech;
  int inter;
  int total=0;
  
  
  posting(int a , int b , int c , int d)
  {
  this.apt = b;
  this.course = a;
  this.tech = c;
  this.inter =d;
  }
  
  
  posting (int p , int q)
  {
   this.tech = p;
   this.inter =q;
  }
  
  posting (int x)
  {
   this.inter =x;
  }
  
  
  
  void program()
  {
  total = apt + course + tech + inter;
  
  if (total>=80)
     {
          System.out.println("You are hired as programmer.");
     }
     else
     {
          System.out.println("You are not hired.");
     }
     
  }
  
  void lead()
  {
   total = tech + inter;
   
   if (total>=85)
     {
          System.out.println("You are hired as team lead.");
     }
     else
     {
          System.out.println("You are not hired.");
     }
   
  }
  
  void manager()
  {
    total = inter;
  
    if (total>=90)
     {
          System.out.println("You are hired as manager.");
     }
     else
     {
          System.out.println("You are not hired.");
     }
  
  }

}


class Employe{
    public static void main (String args[])
    {
    Scanner sc = new Scanner (System.in);
   
    System.out.println("Which role do want to apply for?");
    System.out.println("1.Programmer 2.Team Leader 3.Project Manager");
    int ch = sc.nextInt();

        
    switch(ch)
    {
     case 1:
     {
      System.out.println("coursework: ");
      int cou = sc.nextInt();
      System.out.println("Apttest: ");
      int apt = sc.nextInt();
      System.out.println("TechTest: ");
      int t = sc.nextInt();
      System.out.println("Interview:");
      int inter = sc.nextInt();
      posting c1 = new posting(cou,apt,t,inter);
      c1.program();
      break;
     }
    case 2:
     {
      System.out.println("TechTest: ");
      int t = sc.nextInt();
      System.out.println("Interview:");
      int inter = sc.nextInt();
      posting c1 = new posting(t,inter);
      c1.lead();
      break;
     }
    case 3:
     {
      System.out.println("Enter interview marks");
      int inter = sc.nextInt();
      posting c1 = new posting(inter);
      c1.manager();
      break;
     }
     default:
     {
      System.out.println("ENTER A NUMBER BETWEEN 1 AND 3");
     }
   
    
    
    }
    

    
    
    
    }
}    
