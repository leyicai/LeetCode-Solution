/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int preBuy = Integer.MIN_VALUE, buy = Integer.MIN_VALUE, preSell = 0, sell = 0;
        for (int p : prices) {
            preBuy = buy;
            buy = Math.max(preSell - p, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + p, sell);
        }
        return sell;
    }
}
