/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */
class Solution {
    public String convertToTitle(int n) {
        if (n == 0)
            return "";
        return convertToTitle((n - 1) / 26) + (char) ('A' + (n - 1) % 26);
    }
}
