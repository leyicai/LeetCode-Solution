/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1)
            return s;
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
        int i = 0, n = s.length();
        while (i < n) {
            for (int row = 0; row < numRows && i < n; row++)
                res[row].append(s.charAt(i++));
            for (int row = numRows - 2; row > 0 && i < n; row--)
                res[row].append(s.charAt(i++));
        }
        for (int j = 1; j < numRows; j++) {
            res[0].append(res[j]);
        }
        return res.toString();
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1)
            return s;
        StringBuilder res = new StringBuilder();
        int cycleLen = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += cycleLen) {
                res.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < s.length()) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return res.toString();
    }
}
// @lc code=end
