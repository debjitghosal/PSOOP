package Polymorphism;
import java.util.Scanner;

class RetailP{
    double wholesale;
    int days;

    public RetailP(double wholesale, int days) {
        this.wholesale = wholesale;
        this.days = days;
    }

    double retailPrice(){
        if(days < 0){
            return -1.0;
        }
        else if (days > 0 && days <= 7) {
            return wholesale + wholesale*0.05;
        }

        return wholesale + wholesale*0.1;
    }
}

public class QuickShop {
    public static void main(String[] args) {
        System.out.println("This program determines the retail price for an item at a Quick-Shop supermarket store.");
        Scanner in = new Scanner(System.in);
        double wholesale;
        int days;
        System.out.print("Enter the wholesale cost of item: $");
        wholesale = in.nextDouble();
        System.out.print("Enter the expected number of days until sold: ");
        days = in.nextInt();

        RetailP rp1 = new RetailP(wholesale, days);
        double price =  rp1.retailPrice();

        System.out.println("Wholesale cost = $" + wholesale);
        System.out.println("Expected time until sold = " + days);
        System.out.println("Retail Price = $" + price);

    }
}
