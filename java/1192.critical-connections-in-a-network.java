import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        // generate graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            int from = conn.get(0);
            int to = conn.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        // init arrays
        int[] disc = new int[n];
        int[] low = new int[n]; // init with 0s
        boolean[] visited = new boolean[n];
        Arrays.fill(disc, -1);

        // find bridges
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, graph, res);
            }
        }
        System.out.println(res);
        return res;
    }

    int time = 0;

    private void dfs(int from, int parent, int[] disc, int[] low, boolean[] visited, List<List<Integer>> graph,
            List<List<Integer>> res) {
        visited[from] = true;
        disc[from] = low[from] = ++time;
        for (int to : graph.get(from)) {
            if (to == parent) // ignore parent node
                continue;
            if (!visited[to]) {
                // dfs on this child
                dfs(to, from, disc, low, visited, graph, res);
                // update low of 'from'. 'from' can reach wherever 'to' can reach
                low[from] = Math.min(low[from], low[to]);
                // check if this edge is critical
                if (disc[from] < low[to]) {
                    res.add(new ArrayList<>(Arrays.asList(from, to)));
                }
            } else {
                low[from] = Math.min(low[from], disc[to]);
            }
        }
    }
}
// @lc code=end
