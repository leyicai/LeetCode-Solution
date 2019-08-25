/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int prev = 1, curr;
            for (int j = i; j < n; j++) {
                curr = prev * nums[j];
                res = Math.max(res, curr);
                prev = curr;
            }
        }
        return res;
    }
}

// O(n) time and O(1) space
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevMax = max;
            max = Math.max(nums[i], Math.max(prevMax * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], prevMax * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
