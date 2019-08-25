/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        // multiply in order such that output[i] = profuct of nums[0:i-1]
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        // multiply in reverse order
        int k = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= k;
            k *= nums[i];
        }
        return output;
    }
}
