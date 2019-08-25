/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        int lo, hi, maxLo, maxHi, res;
        lo = 0;
        hi = height.length - 1;
        maxLo = 0;
        maxHi = 0;
        res = 0;

        while (lo <= hi) {
            if (height[lo] <= height[hi]) {
                if (height[lo] >= maxLo)
                    maxLo = height[lo];
                else
                    res += maxLo - height[lo];
                lo++;
            } else {
                if (height[hi] >= maxHi)
                    maxHi = height[hi];
                else
                    res += maxHi - height[hi];
                hi--;
            }
        }
        return res;
    }
}
