import java.util.*;

public class BuildingOffices {
    static int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int W, H;

    public static void main(String[] args) {
        System.out.println(findMinDist(2, 3, 2));
    }

    static int findMinDist(int w, int h, int n) {

        int[][] grid = new int[w][h];
        for (int i = 0; i < w; i++)
            Arrays.fill(grid[i], -1);
        W = w;
        H = h;
        return solve(n, 0, 0, grid);
    }

    static int bfs(int[][] grid) {

        int[][] dist = new int[W][H];
        for (int i = 0; i < W; i++)
            for (int j = 0; j < H; j++)
                dist[i][j] = grid[i][j];

        int maxDist = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < W; i++)
            for (int j = 0; j < H; j++)
                if (dist[i][j] == 0) {
                    queue.add(new Coordinate(i, j));
                }

        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            int currX = curr.x;
            int currY = curr.y;
            maxDist = Math.max(maxDist, dist[currX][currY]);

            for (int[] dir : directions) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];

                if (newX >= W || newY >= H || newX < 0 || newY < 0)
                    continue;
                if (dist[newX][newY] == -1) {
                    dist[newX][newY] = dist[currX][currY] + 1;
                    queue.add(new Coordinate(newX, newY));
                }
            }
        }
        return maxDist;
    }

    static int solve(int left, int row, int col, int[][] grid) {
        if (left == 0) {
            return bfs(grid);
        }
        int r = row, c = col;
        if (col >= H) {
            r += col / H;
            c = col % H;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = r; i < W; i++) {
            for (int j = c; j < H; j++) {
                // Mark Building locations in the recursive call.
                grid[i][j] = 0;
                int val = solve(left - 1, i, j + 1, grid);
                minDistance = Math.min(minDistance, val);
                // Remove the building
                grid[i][j] = -1;
            }
        }
        return minDistance;
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}