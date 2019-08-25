/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 * 
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j;
        for (i = 1, j = 1; j < nums.length; j++) {
            if (nums[i - 1] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
