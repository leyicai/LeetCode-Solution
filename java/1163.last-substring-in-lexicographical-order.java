/*
 * @lc app=leetcode id=1163 lang=java
 *
 * [1163] Last Substring in Lexicographical Order
 */

// @lc code=start
class Solution {
    // TLE
    // public String lastSubstring(String s) {
    // String res = "";
    // for (int i = s.length() - 1; i >= 0; i--) {
    // String suffix = s.substring(i);
    // if (suffix.compareTo(res) > 0) {
    // res = suffix;
    // }
    // }
    // return res;
    // }

    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, len = 0;
        while (i + len < n && j + len < n) {
            if (s.charAt(i + len) == s.charAt(j + len)) {
                len++;
            } else {
                if (s.charAt(i + len) < s.charAt(j + len)) {
                    i += len + 1;
                } else {
                    j += len + 1;
                }
                if (i == j)
                    j++;
                len = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}
// @lc code=end
