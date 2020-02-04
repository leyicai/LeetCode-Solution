/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 */

// @lc code=start
class Solution {
    public boolean isStrobogrammatic(String s) {
        int i = 0, j = s.length() - 1;
        String sym = "00 11 88 69 96";
        while (i <= j) {
            if (sym.contains(s.charAt(i) + "" + s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
