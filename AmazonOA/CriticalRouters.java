import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CriticalRouters {
    public List<Integer> criticalRouters(int n, List<List<Integer>> connections) {
        List<Integer> res = new ArrayList<>();
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

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // in case the graph has more than one connected components
                int outEdge = 0;
                dfs(outEdge, i, i, -1, disc, low, visited, graph, res); // starts with parent as -1(root)
                if (outEdge > 1) {
                    // root with more than one out edge
                    res.add(i);
                }
            }
        }
        return res;
    }

    int time = 0;

    private void dfs(int outEdge, int root, int from, int parent, int[] disc, int[] low, boolean[] visited,
            List<List<Integer>> graph, List<Integer> res) {
        if (parent == root) {
            outEdge++;
        }

        visited[from] = true;
        disc[from] = low[from] = ++time; // init low as the discover time
        for (int to : graph.get(from)) {
            if (to == parent) // ignore parent node
                continue;
            if (!visited[to]) {
                // dfs on this unvisited child
                dfs(outEdge, root, to, from, disc, low, visited, graph, res);
                // update low of 'from'. 'from' can reach wherever 'to' can reach
                low[from] = Math.min(low[from], low[to]);
                // check AP. combine the bridge and cycle condition together
                if (disc[from] <= low[to] && from != root) {
                    // System.out.println(from + " " + to);
                    res.add(from);
                }
            } else {
                // visited node
                low[from] = Math.min(low[from], disc[to]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalRouters cr = new CriticalRouters();
        int numRouters1 = 7;
        // int numLinks1 = 6;
        int[][] links1 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 3, 4 }, { 5, 6 } };
        List<List<Integer>> list1 = new ArrayList<>();
        for (int i = 0; i < links1.length; i++) {
            list1.add(new ArrayList<>());
            for (int j = 0; j < links1[i].length; j++) {
                list1.get(i).add(links1[i][j]);
            }
        }
        System.out.println(cr.criticalRouters(numRouters1, list1));
        // int numRouters2 = 5;
        // int numLinks2 = 5;
        // int[][] links2 = { { 0, 1 }, { 1, 2 }, { 0, 2 }, { 0, 3 }, { 3, 4 } };
        // System.out.println(getCriticalNodes(links2, numLinks2, numRouters2));
        // int numRouters3 = 4;
        // int numLinks3 = 3;
        // int[][] links3 = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        // System.out.println(getCriticalNodes(links3, numLinks3, numRouters3));
        // int numRouters4 = 7;
        // int numLinks4 = 7;
        // int[][] links4 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6
        // }, { 3, 4 } };
        // System.out.println(getCriticalNodes(links4, numLinks4, numRouters4));
        // int numRouters5 = 4;
        // int numLinks5 = 4;
        // int[][] links5 = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        // System.out.println(getCriticalNodes(links5, numLinks5, numRouters5));
    }
}
// @lc code=end
