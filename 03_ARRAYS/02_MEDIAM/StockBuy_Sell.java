// Stock Buy And Sell
// Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and 
// sell on day 5 (price = 6), profit = 6-1 = 5.

// Note: That buying on day 2 and selling on day 1 
// is not allowed because you must buy before 
// you sell.

// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are 
// done and the max profit = 0.

public class StockBuy_Sell {
    public static int MySol(int[] arr) {
        int lowest = Integer.MAX_VALUE, idx = 0;
        int profit = 0, maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
                idx = i;
            }
        }
        if (idx + 1 < arr.length) {
            for (int i = idx + 1; i < arr.length; i++) {
                profit = arr[i] - lowest;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    static int maxProfit(int[] arr) { // Burte Force
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }

    static int Optimal(int[] arr) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 6, 4, 3, 1 };
        System.out.println(MySol(arr));
    }

}
