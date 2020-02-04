/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}
