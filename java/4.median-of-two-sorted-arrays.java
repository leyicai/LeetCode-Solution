/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length + b.length;
        return (kthSmallest(a, b, 0, 0, (n + 1) / 2) + kthSmallest(a, b, 0, 0, (n + 2) / 2)) / 2.0;
    }

    // Find the kth smallest num from a[i:] and b[j:]
    private double kthSmallest(int[] a, int[] b, int i, int j, int k) {
        if (i >= a.length)
            return b[j + k - 1];
        if (j >= b.length)
            return a[i + k - 1];
        if (k == 1)
            return Math.min(a[i], b[j]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (i + k / 2 - 1 < a.length)
            aMid = a[i + k / 2 - 1];
        if (j + k / 2 - 1 < b.length)
            bMid = b[j + k / 2 - 1];

        // Throw away half of the array from a or b. And cut k in half
        if (aMid < bMid)
            return kthSmallest(a, b, i + k / 2, j, k - k / 2);
        else
            return kthSmallest(a, b, i, j + k / 2, k - k / 2);
    }
}
