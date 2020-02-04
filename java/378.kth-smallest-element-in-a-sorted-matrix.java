import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> matrix[a.x][a.y] - matrix[b.x][b.y]);
        // add elements in first row into pq
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Node(0, i));
        }
        // poll first k elements
        Node node = null;
        for (int i = 0; i < k; i++) {
            node = pq.poll();
            if (node.x == matrix.length - 1)
                continue;
            pq.offer(new Node(node.x + 1, node.y)); // add elements from next row
        }
        return matrix[node.x][node.y];
    }

    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1], mid;
        int count;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            count = 0;
            // search from top right
            // find out #elements <= mid in the matrix
            for (int i = 0, j = matrix.length - 1; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    // if >mid, move left
                    j--;
                }
                if (j >= 0) {
                    count += (j + 1);
                }
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
// @lc code=end
