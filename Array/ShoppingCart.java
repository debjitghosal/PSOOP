/*  
Create a class called ShoppingCart to represent the following scenario: 

In a mall, a conveyor belts holds “c” carts at a time. Each cart may contain variable number of items, items which are either Perishable or Non-perishable category items. Create a 3D array named as cart which stores the cost of items purchased.  

Hint: Use Ragged/Jagged Arrays 

For c=3, find out: 

a) Total cost of each cart.

b) Find out all perishable items sold (on 3 carts).

c) Find out the costliest non-perishable item sold.*/

import java.util.*;

class cart
{
    int[][][] data=new int [3][2][];
    int [] no_of_items = new int[3];
    cart()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 stands for a perisible item , 2 is non perisible");
        
        for(int k =0 ; k<3;k++)
        {
        System.out.println("Enter number of items in cart"+(k+1));
        no_of_items[k]=sc.nextInt();
        data[k][0] = new int[no_of_items[k]];
        data[k][1] = new int[no_of_items[k]];
        }
        
        for (int j = 0; j < 3; j++) {
            
        System.out.println("Enter info for cart "+(j+1));
        for (int i = 0; i < no_of_items[j]; i++) 
        {
          System.out.println("Enter Data for item:"+(i+1));
          System.out.println("Enter perishibility info:");
          data[j][0][i]=sc.nextInt();
          
          if (data[j][0][i]==0) 
          {
           System.out.println("invalid Input");
           System.exit(0);
          }
          
          System.out.println("Enter Price: ");
          data[j][1][i]=sc.nextInt();    
        }
    }
        
        sc.close();
    }

    void tot_cost()
    {
        int tot_cost=0;
        for (int j = 0; j < 3; j++) {
            tot_cost=0;
        for (int i = 0; i < no_of_items[j]; i++) {
            tot_cost+=data[j][1][i];
        }
        System.out.printf("Total cost of cart %d is: %d \n",(j+1),tot_cost);
       }
    }

    void cost_of_perish()
    {
        int cost_of_perish=0;
        for (int j = 0; j < 3; j++) {
            
        
        for (int i = 0; i < no_of_items[j]; i++) 
        {
          if (data[j][0][i]==1) 
          {
            cost_of_perish+=data[j][1][i];
          }  
        }
        System.out.printf("Total Cost of perishible items is %d \n",cost_of_perish);
       }
    }

    void max_non_perish()
    {
        int max_non_perish=0;

        for (int j = 0; j < 3; j++) 
        {
            
        for (int i = 0; i < no_of_items[j]; i++) 
        {
              if (data[j][1][i]>max_non_perish && data[j][0][i]==2) 
              // if data is of non perishible type and value is > than previous non perish one then new max = value
              {
                max_non_perish=data[j][1][i];
              }
           
        }
        System.out.printf("Maximum cost of non perishible item is %d \n",max_non_perish);
       }
    }
    
}

public class ShoppingCart {
    public static void main(String[] args) {
        cart c1 = new cart();


        c1.tot_cost();
        c1.max_non_perish();
        c1.cost_of_perish();
    }
}
