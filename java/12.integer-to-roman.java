/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */
class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] chars = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        StringBuilder res = new StringBuilder();
        for (int i = 12; i >= 0; i--) {
            while (num >= nums[i]) {
                res.append(chars[i]);
                num -= nums[i];
            }
        }
        return res.toString();
    }
}
