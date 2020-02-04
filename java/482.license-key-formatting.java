/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S.toUpperCase().replace("-", "");
        StringBuilder s = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-')
                s.append(s.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
        }
        return s.reverse().toString();
    }
}
// @lc code=end
