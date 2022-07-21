package best.interview.questions.easy;

import java.util.Arrays;
import java.util.Random;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();

        while (true) {
            crashTest(sellStock);
        }
    }

    private static void crashTest(BestTimeToBuyAndSellStock sellStock) {
        Random random = new Random();
        int[] prices = new int[10];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = random.nextInt(10);
        }
        int actual = sellStock.maxProfit(prices);
        int expected = sellStock.maxProfitNaive(prices);
        if (actual != expected) {
            System.out.printf("actual %s isn't equal to expected %s\n", actual, expected);
            System.out.println(Arrays.toString(prices));
            throw new RuntimeException();
        }
    }

    public int maxProfitNaive(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }


    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                if (max - min > profit) {
                    profit = max - min;
                }
            }
            if (prices[i] < min) {
                min = prices[i];
                max = 0;
            }
        }
        return profit;
    }
}
