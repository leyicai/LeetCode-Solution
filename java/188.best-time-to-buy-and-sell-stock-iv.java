/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        // if k >= n/2, you can make maximum number of transactions.
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[][] dp = new int[k + 1][n];
        for (int j = 1; j <= k; j++) {
            int maxDiff = dp[j - 1][0] - prices[0];
            for (int i = 1; i < n; i++) {
                maxDiff = Math.max(maxDiff, dp[j - 1][i] - prices[i]);
                dp[j][i] = Math.max(dp[j][i - 1], prices[i] + maxDiff);
            }
        }
        return dp[k][n - 1];
    }
}
