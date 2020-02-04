/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            if (nums[i] < nums[i + 1])
                down = up + 1;
        }
        return Math.max(up, down);
    }
}

// Greedy
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 1, prevDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((prevDiff >= 0 && diff < 0) || (prevDiff <= 0 && diff > 0)) {
                res++;
                prevDiff = diff;
            }
        }
        return res;
    }
}
