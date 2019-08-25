/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        int area = 0, lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int edge = Math.min(height[lo], height[hi]);
            area = Math.max(area, edge * (hi - lo));
            if (height[lo] < height[hi])
                lo++;
            else
                hi--;
        }
        return area;
    }
}
