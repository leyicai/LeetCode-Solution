import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/*
 * @lc app=leetcode id=256 lang=java
 *
 * [256] Paint House
 */

// @lc code=start
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0] = costs[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (dp[n - 1][j] < res)
                res = dp[n - 1][j];
        }

        return res;
    }

    // 1-D dp
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length;
        int[] dp = new int[3];
        dp = costs[0];
        for (int i = 1; i < n; i++) {
            int r = dp[0], g = dp[1], b = dp[2];
            r = Math.min(dp[1], dp[2]) + costs[i][0];
            g = Math.min(dp[0], dp[2]) + costs[i][1];
            b = Math.min(dp[0], dp[1]) + costs[i][2];
            dp[0] = r;
            dp[1] = g;
            dp[2] = b;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
// @lc code=end
