/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class Solution {
    // count in two array
    // for a value, if countA + countB - countAB == n: a valid solution
    // min rotation = n - max(countA, countB)
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int[] countA = new int[7], countB = new int[7], countAB = new int[7];
        for (int i = 0; i < n; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                countAB[A[i]]++;
        }
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - countAB[i] >= n) {
                return n - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }

    // check with two starting value
    // check if one of the array can be turn into all val = candidate
    public int minDominoRotations(int[] A, int[] B) {
        int res = checkCandidate(A, B, A[0]);
        if (res == -1)
            return checkCandidate(A, B, B[0]);
        return res;
    }

    private int checkCandidate(int[] A, int[] B, int candidate) {
        int rotateA = 0, rotateB = 0, n = A.length;
        for (int i = 0; i < n && (A[i] == candidate || B[i] == candidate); i++) {
            if (A[i] != candidate)
                rotateA++;
            if (B[i] != candidate)
                rotateB++;
            if (i == n - 1)
                return Math.min(rotateA, rotateB);
        }
        return -1;
    }
}
// @lc code=end
