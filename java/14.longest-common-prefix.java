/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0 && res.length() > 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
