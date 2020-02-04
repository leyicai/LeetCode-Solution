import java.util.*;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    // BFS from rotten ones
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    // count fresh ones
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                for (int[] dir : directions) {
                    int i = node[0] + dir[0];
                    int j = node[1] + dir[1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2)
                        continue;
                    // for the fresh ones:
                    // mark as rotten
                    grid[i][j] = 2;
                    // decrease fresh count
                    fresh--;
                    queue.offer(new int[] { i, j });
                }
            }
        }
        return fresh == 0 ? time - 1 : -1;
    }

    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}
// @lc code=end
