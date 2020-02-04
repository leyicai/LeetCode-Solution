/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 */

// @lc code=start
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s)
        }
        // compare length
        if (s.length() - t.length() > 1)
            return false;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (i == t.length() - 1) {
                    // T: 123/121 123/13 F: 1203/121
                    return i == s.length() - 1 || t.charAt(i) == s.charAt(i + 1);
                }
                return s.substring(i + 1).equals(t.substring(i)) || s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return !s.equals(t); // same
    }
}
// @lc code=end
