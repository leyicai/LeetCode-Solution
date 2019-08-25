/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */
// class Solution {
//     public void gameOfLife(int[][] board) {
//         int rows, cols;
//         rows = board.length;
//         cols = board[0].length;
//         // copy the board
//         int[][] copy = new int[rows][cols];
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 copy[i][j] = board[i][j];
//             }
//         }
//         int[] directions = { 0, -1, 1 };
//         // update the board
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 int liveNeighbor = 0;
//                 for (int ii = 0; ii < 3; ii++) {
//                     for (int jj = 0; jj < 3; jj++) {
//                         int row = i + directions[ii];
//                         int col = j + directions[jj];
//                         if (row < 0 || row >= rows || col < 0 || col >= cols)
//                             continue;
//                         else {
//                             liveNeighbor += copy[row][col];
//                         }
//                     }
//                 }
//                 liveNeighbor -= board[i][j];
//                 if (liveNeighbor < 2 || liveNeighbor > 3)
//                     board[i][j] = 0;
//                 if (liveNeighbor == 3)
//                     board[i][j] = 1;
//             }
//         }
//     }
// }

// O(1) space
class Solution {
    public void gameOfLife(int[][] board) {
        int rows, cols;
        rows = board.length;
        cols = board[0].length;

        int[] directions = { 0, -1, 1 };
        // update the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbor = 0;
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        int row = i + directions[ii];
                        int col = j + directions[jj];
                        if (row < 0 || row >= rows || col < 0 || col >= cols || (ii + jj) == 0)
                            continue;
                        else if (Math.abs(board[row][col]) == 1) {
                            liveNeighbor++;
                        }
                    }
                }
                if ((liveNeighbor < 2 || liveNeighbor > 3) && board[i][j] == 1)
                    board[i][j] = -1;
                if (liveNeighbor == 3 && board[i][j] == 0)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}
