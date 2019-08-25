/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i, j;
        for (i = 2, j = 2; j < nums.length; j++) {
            if (nums[i - 2] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
