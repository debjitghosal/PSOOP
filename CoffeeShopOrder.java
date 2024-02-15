import java.util.Scanner;

public class CoffeeShopOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coffee options and prices
        String[] coffeeOptions = {"Espresso", "Latte", "Cappuccino"};
        int[] coffeePrices = {100, 200, 300};

        // Display coffee menu
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Menu:");
        for (int i = 0; i < coffeeOptions.length; i++) {
            System.out.println((i + 1) + ". " + coffeeOptions[i] + " - Rs." + coffeePrices[i]);
        }

        // Ask for coffee choice
        System.out.println("Please enter the number of the coffee you'd like to order:");
        int choice = scanner.nextInt();
        int quantity = 0;
        if (choice >= 1 && choice <= coffeeOptions.length) {
            System.out.println("How many cups would you like to order?");
            quantity = scanner.nextInt();
        } else {
            System.out.println("Invalid choice. Please choose from the menu.");
            System.exit(0);
        }

        // Calculate total bill
        int totalPrice = coffeePrices[choice - 1] * quantity;
        System.out.println("Total bill amount: Rs." + totalPrice);

        // Payment options
        System.out.println("Payment Options:");
        System.out.println("1. Cash");
        System.out.println("2. Online/UPI");
        System.out.println("Please select a payment method:");

        int paymentOption = scanner.nextInt();
        if (paymentOption == 1) {
            // Cash payment
            System.out.println("Enter the Amount paid:");
            int amountPaid = scanner.nextInt();
            int change = amountPaid - totalPrice;
            System.out.println("Change returned: Rs." + change + " 😊");
        } else if (paymentOption == 2) {
            // Online/UPI payment
            System.out.println("Scan the QR code");
            // Proceed with online payment (imaginary QR code scanning)
            System.out.println("Online payment successful. Thank you!");
        } else {
            System.out.println("Invalid payment option selected. Please try again.");
        }

        System.out.println("Enjoy your coffee!");
        scanner.close();
    }
}
