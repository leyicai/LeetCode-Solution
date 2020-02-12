import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class UnionFind {
    private int[] parents;
    private int[] rank;
    private int num;

    public UnionFind(int n) {
        num = n;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        rank = new int[n];
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
}

class Result {

    /*
     * Complete the 'connectedCities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER n 2. INTEGER g 3. INTEGER_ARRAY originCities
     * 4. INTEGER_ARRAY destinationCities
     */

    private static int gcd(int x, int y) {
        while (y != 0) {
            int remain = x % y;
            x = y;
            y = remain;
        }
        return x;
    }

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities,
            List<Integer> destinationCities) {
        UnionFind uf = new UnionFind(n + 1);
        for (int i = g + 1; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (gcd(i, j) > g)
                    uf.union(i, j);
            }
        }
        int q = originCities.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int origin = uf.find(originCities.get(i)), dest = uf.find(destinationCities.get(i));
            if (origin == dest) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        return res;
    }

}

public class TravellingFun {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        int originCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> originCities = IntStream.range(0, originCitiesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int destinationCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> destinationCities = IntStream.range(0, destinationCitiesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        List<Integer> result = Result.connectedCities(n, g, originCities, destinationCities);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
