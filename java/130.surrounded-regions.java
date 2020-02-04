import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        n = board.length;
        m = board[0].length;
        if (n < 2 || m < 2)
            return;
        // dfs from 'O' on borders, change to '.'
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board);
            }
        }
        for (int j = 1; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board);
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board);
            }
        }
        // flip the rest 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '.';
            if (i > 1)
                dfs(i - 1, j, board);
            if (i < n - 1)
                dfs(i + 1, j, board);
            if (j > 1)
                dfs(i, j - 1, board);
            if (j < m - 1)
                dfs(i, j + 1, board);
        }
    }

    int n, m;

    // bfs
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int n = board.length;
        int m = board[0].length;
        if (n < 2 || m < 2)
            return;
        Queue<int[]> queue = new LinkedList<>();
        // add 'O' on the borders to list
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '.';
                queue.add(new int[] { i, 0 });
            }
            if (board[i][m - 1] == 'O') {
                board[i][m - 1] = '.';
                queue.add(new int[] { i, m - 1 });
            }
        }
        for (int j = 1; j < m; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '.';
                queue.add(new int[] { 0, j });
            }
            if (board[n - 1][j] == 'O') {
                board[n - 1][j] = '.';
                queue.add(new int[] { n - 1, j });
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '.';
                queue.add(new int[] { i - 1, j });
            }
            if (i + 1 < n && board[i + 1][j] == 'O') {
                board[i + 1][j] = '.';
                queue.add(new int[] { i + 1, j });
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '.';
                queue.add(new int[] { i, j - 1 });
            }
            if (j + 1 < m && board[i][j + 1] == 'O') {
                board[i][j + 1] = '.';
                queue.add(new int[] { i, j + 1 });
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
        }
    }
}
// @lc code=end
