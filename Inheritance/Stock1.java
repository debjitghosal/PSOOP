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

