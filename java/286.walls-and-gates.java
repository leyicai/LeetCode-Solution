import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    // gates
                    queue.offer(new int[] { i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : directions) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] != Integer.MAX_VALUE)
                    continue;
                rooms[i][j] = rooms[curr[0]][curr[1]] + 1;
                queue.offer(new int[] { i, j });
            }
        }
    }

    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}
// @lc code=end
