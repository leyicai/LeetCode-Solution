public class UnionFind {

    private int[] parents;
    private int[] rank;
    private int num; // size of unionfind

    public UnionFind(int N) {
        num = N;
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        rank = new int[N];
    }

    public int find(int i) {
        return (parents[i] == i) ? i : find(parents[i]);
    }

    public boolean union(int i, int j) {
        int pi = find(i), pj = find(j);
        if (pi == pj)
            return false;
        if (rank[pi] > rank[pj]) {
            parents[pj] = pi;
        } else {
            parents[pi] = pj;
            if (rank[pi] == rank[pj])
                rank[pj]++;
        }
        num--;
        return true;
    }

    public int size() {
        return num;
    }
}