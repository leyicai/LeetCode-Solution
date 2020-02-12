import java.util.*;

class UnionFind {

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

public class TravellingIsFun {

    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        UnionFind uf = new UnionFind(n + 1);
        for (int i = g + 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                if (gcd(i, j) > g) {
                    uf.union(i, j);
                }
            }
        }
        int q = originCities.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int a = uf.find(originCities[i]);
            int b = uf.find(destinationCities[i]);
            if (a == b) {
                result[i] = 1;
            }
        }
        return result;
    }

    private static int gcd(int x, int y) {

        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int g = in.nextInt();
        int originCities_cnt = in.nextInt();
        int[] originCities = new int[originCities_cnt];
        for (int originCities_i = 0; originCities_i < originCities_cnt; originCities_i++) {
            originCities[originCities_i] = in.nextInt();
        }
        int destinationCities_cnt = in.nextInt();
        int[] destinationCities = new int[destinationCities_cnt];
        for (int destinationCities_i = 0; destinationCities_i < destinationCities_cnt; destinationCities_i++) {
            destinationCities[destinationCities_i] = in.nextInt();
        }
        int[] res = connectedCities(n, g, originCities, destinationCities);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i != res.length - 1 ? "\n" : ""));
        }
        System.out.println("");

        in.close();
    }
}