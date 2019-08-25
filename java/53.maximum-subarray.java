/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int[] opt = new int[nums.length];
//         int res = nums[0];
//         opt[0] = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             opt[i] = nums[i] + Math.max(opt[i - 1], 0);
//             res = Math.max(res, opt[i]);
//         }
//         return res;
//     }
// }

// divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int crossSum = crossSubArray(nums, left, right);
        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    private int crossSubArray(int[] nums, int left, int right) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;
        int mid = (left + right) / 2;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
