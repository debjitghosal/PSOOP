package ExceptionHandling;
/*
 There is an abstract class Account

Attribute:-

● Name

● Balance

● Acc_No

Method:-

● Deposit - abstract method

● withdraw - abstract method

● display - abstract method

Saving Account inherits the Account class and provides the implementation for the methods accordingly

Saving Account class Attribute:-

● interestRate

● minBalance

Method

● addInterest: handle Arithmetic Exception

● transfer():

Note:

● Balance cannot be less than 0.

● In a Saving account if minBalance is set then for that the balance

cannot go less than that amount. If it goes, an error must be shown.

● let the user deposit to or withdraw from the account. For each

transaction, a message is displayed to indicate the status of the

transaction: successful or failed. In case of failure, the failure

reason is reported.

● The possible Exceptions are negative-amount-exception (in both

deposit and withdraw transaction) and insufficient-amount-

exception ( in withdraw transaction).

For the above scenario write an interactive program in Java. Also, show output for different use cases.

*/

import java.util.Scanner;

// Abstract class Account
abstract class Account {
    String name;
    double balance;
    int acc_No;

    // Abstract methods
    abstract void deposit(double amount) throws NegativeAmountException;
    abstract void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException;
    abstract void display();
}

// Custom Exception for Negative Amount
class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

// Custom Exception for Insufficient Amount
class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}

// Saving Account class inherits Account
class SavingAccount extends Account {
    double interestRate;
    double minBalance;

    SavingAccount(String name, double balance, int acc_No, double interestRate, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.acc_No = acc_No;
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    // Deposit implementation
    void deposit(double amount) throws NegativeAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Deposit amount cannot be negative.");
            }
            balance += amount;
            System.out.println("Deposit Successful. Current Balance: " + balance);
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Withdraw implementation
    void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Withdraw amount cannot be negative.");
            }
            if (balance - amount < minBalance) {
                throw new InsufficientAmountException("Insufficient balance to withdraw.");
            }
            balance -= amount;
            System.out.println("Withdrawal Successful. Current Balance: " + balance);
        } catch (NegativeAmountException | InsufficientAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display implementation
    void display() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + acc_No);
        System.out.println("Current Balance: " + balance);
    }

    // Add interest method with Arithmetic Exception handling
    void addInterest() {
        try {
            balance += balance * interestRate / 100;
            System.out.println("Interest Added. Current Balance: " + balance);
        } catch (ArithmeticException e) {
            System.out.println("Error adding interest: " + e.getMessage());
        }
    }

    // Transfer method
    void transfer(double amount, Account recipient) throws NegativeAmountException, InsufficientAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Transfer amount cannot be negative.");
            }
            if (balance - amount < minBalance) {
                throw new InsufficientAmountException("Insufficient balance to transfer.");
            }
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transfer Successful.");
        } catch (NegativeAmountException | InsufficientAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Main12345 {
    public static void main(String[] args) throws NegativeAmountException, InsufficientAmountException {
        Scanner scanner = new Scanner(System.in);

        // Creating Saving Account
        SavingAccount account = new SavingAccount("John Doe", 1000, 123456, 5, 500);

        // Interactive menu
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Info");
            System.out.println("4. Add Interest");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.display();
                    break;
                case 4:
                    account.addInterest();
                    break;
                case 5:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter recipient account number: ");
                    int recipientAccountNo = scanner.nextInt();
                    // Assuming recipient account is another SavingAccount object
                    SavingAccount recipient = new SavingAccount("Recipient", 0, recipientAccountNo, 0, 0);
                    try {
                        account.transfer(transferAmount, recipient);
                    } catch (NegativeAmountException | InsufficientAmountException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
