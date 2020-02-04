import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], order = new int[numCourses];
        List<List<Integer>> adjLists = new ArrayList<>();
        initGraph(inDegree, prerequisites, adjLists);
        int idx = 0; // index of order
        Queue<Integer> queue = new LinkedList<>(); // queue for BFS

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                // no prerequisite
                queue.offer(i);
            }
        }
        System.out.println(queue);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            order[idx++] = from;
            for (int to : adjLists.get(from)) {
                inDegree[to]--;
                if (inDegree[to] == 0)
                    queue.offer(to);
                else if (inDegree[to] < 0)
                    return new int[0];
            }
        }

        return idx == numCourses ? order : new int[0];
    }

    private void initGraph(int[] inDegree, int[][] prerequisites, List<List<Integer>> adjLists) {
        for (int i = 0; i < inDegree.length; i++) {
            adjLists.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
            adjLists.get(edge[1]).add(edge[0]);
        }
        System.out.println(Arrays.toString(inDegree));
    }
}
// @lc code=end
