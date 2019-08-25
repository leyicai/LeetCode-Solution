/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (!set.add(n))
                return true;
        }
        return false;
    }
}
