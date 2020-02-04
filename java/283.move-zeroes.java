/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int lo = 0, hi = 1;
        while (lo < nums.length && hi < nums.length) {
            while (nums[lo] == 0) {
                nums[lo] = nums[hi];
                nums[hi] = 0;
                hi++;
            }
            lo++;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }
}
