import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    ////////// DP
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp.length; j++) {
                if (i == j)
                    dp[i][j] = 0;
                else if (i + 1 == j)
                    dp[i][j] = arr[i] * arr[j];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int tmp = dp[i][k] + dp[k + 1][j] + max(arr, i, k) * max(arr, k + 1, j);
                        min = Math.min(min, tmp);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][arr.length - 1];
    }

    private int max(int[] arr, int start, int end) {
        if (start > end)
            return Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    /////////// Monotone Stack
    // numbers in stack decrease motonely
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for (int num : arr) {
            while (num >= stack.peek()) {
                int min = stack.pop();
                res += min * Math.min(num, stack.peek());
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
// @lc code=end
