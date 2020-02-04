/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int num1, num2;
        for (int i = 0; i < v2.length || i < v1.length; i++) {
            num1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            num2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
// @lc code=end
