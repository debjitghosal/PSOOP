/*
PROBLEM STATEMENT :	The cost of stock on each day is given in an array A[] of size N. Day 1 price in first location, day 2 price in
second location etc. Find all the days on which you buy and sell the stock any number of times so that in
between those days your profit is maximum.A new transaction can only start after the previous
transaction is complete. Person can hold only one share at a time. Create a class Stock that has the name
of stock and array of prices. Also it has input method that initialises the predicted price of the stock in an
array of length N. Create class Transaction that is a sub class of Stock class. It has method
findMaximumProfit method.
Example Stock Prices: {1, 5, 2, 3, 7, 6, 4, 5}
Total profit earned is 10
Buy on day 1 and sell on day 2
Buy on day 3 and sell on day 5
Buy on day 7 and sell on day 8
*/

import java.util.*;

class Stock {
    String name;
    int[] prices;

    public Stock(String name, int[] prices) {
        this.name = name;
        this.prices = prices;
    }
}

class Transaction extends Stock {
    public Transaction(String name, int[] prices) {
        super(name, prices);
    }

    public void findMaximumProfit() {
        int maxProfit = 0;
        List<Integer> buyDays = new ArrayList<>();
        List<Integer> sellDays = new ArrayList<>();
        int buyDay = 0;
        int sellDay = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                buyDays.add(i);
                buyDay = i;
                while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                    i++;
                }
                sellDays.add(i);
                sellDay = i;
                maxProfit += prices[sellDay] - prices[buyDay];
            }
        }

        System.out.println("Total profit earned is " + maxProfit);
        for (int i = 0; i < buyDays.size(); i++) {
            System.out.println("Buy on day " + (buyDays.get(i) + 1) + " and sell on day " + (sellDays.get(i) + 1));
        }
    }
}

public class Stock1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the stock: ");
        String stockName = scanner.nextLine();

        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for day " + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }

        Transaction transaction = new Transaction(stockName, prices);
        transaction.findMaximumProfit();
    }
}

