/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 * 
 * dp[i][j]: max profit on day i with up to j transactions
 * dp[i][j] = max between:
 *            1. already j transaction before day i: dp[i-1][j]
 *            2. j-1 transctions before day k(k < i) and make transaction on day i:
 *               max(dp[k][j-1] + prices[i] - prices[k]) = prices[i] + max(dp[k][j-1] - prices[k])
 * dp[0][j] = 0, on day 0 no transaction was made
 * dp[i][0] = 0, 0 transcation
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0;
        if (n < 2)
            return 0;
        int[][] dp = new int[n][3];
        for (int j = 1; j < 3; j++) {
            int maxDiff = dp[0][j - 1] - prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], maxDiff + prices[i]);
                maxDiff = Math.max(dp[i][j - 1] - prices[i], maxDiff);
                profit = Math.max(dp[i][j], profit);
            }
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int p : prices) {
            profit2 = Math.max(profit2, p - buy2); // sell all stock to get final profit
            buy2 = Math.min(buy2, p - profit1); // sell first stock(profit1) and buy the second stock; or to say, use
                                                // profit1 to buy second stock
            profit1 = Math.max(profit1, p - buy1);
            buy1 = Math.min(buy1, p); // buy the lowest one
        }
        return profit2;
    }
}
