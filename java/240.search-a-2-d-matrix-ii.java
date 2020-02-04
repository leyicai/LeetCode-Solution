/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        // start search from top right corner
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
// @lc code=end
