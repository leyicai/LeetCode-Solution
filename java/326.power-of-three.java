/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }

    public boolean isPowerOfThree(int n) {
        String baseThree = Integer.toString(n, 3);
        return baseThree.matches("^10*$");
    }
}
// @lc code=end
