import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    // dfs
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0'; // mark as visited
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    // bfs
    public int numIslands(char[][] grid) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[] { i, j });
                    grid[i][j] = '0';
                    bfs(grid, queue);
                    res++;
                }
            }
        }
        return res;
    }

    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void bfs(char[][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir : directions) {
                int i = node[0] + dir[0];
                int j = node[1] + dir[1];
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
                    continue;
                grid[i][j] = '0';
                queue.offer(new int[] { i, j });
            }
        }
    }

    // union find
    int[][] directions = { { 0, -1 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int[] parent = new int[n * m];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    parent[i * m + j] = i * m + j;
                    res++;
                    for (int[] dir : directions) {
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if (ii < 0 || ii >= n || jj < 0 || jj >= m || grid[ii][jj] == '0')
                            continue;
                        int parent1 = find(parent, i * m + j);
                        int parent2 = find(parent, ii * m + jj);
                        if (parent1 != parent2) {
                            res--;
                            parent[parent2] = parent1;
                        }
                    }
                }
            }
        }

        return res;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent, parent[x]);
        }
    }
}
// @lc code=end