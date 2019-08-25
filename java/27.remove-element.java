/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            while (nums[lo] == val && lo <= hi) {
                nums[lo] = nums[hi];
                hi--;
            }
            lo++;
        }
        return hi + 1;
    }
}
