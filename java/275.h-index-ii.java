/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */
class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, hi = citations.length - 1, mid;
        int n = citations.length;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (n - mid <= citations[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return n - lo;
    }
}
