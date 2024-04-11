// A banking system has two interfaces SavingAccount and CurrentAccount. 

// The SavingAccount account has method getSimpleInterest() and CurrentAccont has method getCompoudInterest(). 
// Both these interfaces are implemented by class Customer. Customer have data members: account type, interest rate and balance. 
// The class then calculates interest on balance and prints it. 


package Abstraction.Interfaces;
interface SavingAccount {
    double getSimpleInterest();
}

interface CurrentAccount {
    double getCompoundInterest();
}

class Customer implements SavingAccount, CurrentAccount {
    private String accountType;
    private double interestRate;
    private double balance;

    public Customer(String accountType, double interestRate, double balance) {
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    @Override
    public double getSimpleInterest() {
        // Calculate simple interest
        double simpleInterest = (balance * interestRate) / 100;
        return simpleInterest;
    }

    @Override
    public double getCompoundInterest() {
        // Assuming compound interest is calculated annually
        double compoundInterest = balance * Math.pow(1 + (interestRate / 100), 1) - balance;
        return compoundInterest;
    }

    public void printInterest() {
        if (accountType.equalsIgnoreCase("Saving")) {
            System.out.println("Simple interest on saving account: " + getSimpleInterest());
        } else if (accountType.equalsIgnoreCase("Current")) {
            System.out.println("Compound interest on current account: " + getCompoundInterest());
        } else {
            System.out.println("Invalid account type!");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Customer savingCustomer = new Customer("Saving", 5.0, 1000);
        Customer currentCustomer = new Customer("Current", 6.0, 1500);

        savingCustomer.printInterest();
        currentCustomer.printInterest();
    }
}
