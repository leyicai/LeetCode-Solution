class Solution {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++i) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else
					dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}

// Math
// res = C_(m+n-2)^(m-1)
public int uniquePaths(int m, int n) {
	long result = 1;
	for (int i = 0; i < Math.min(m - 1, n - 1); i++)
		result = result * (m + n - 2 - i) / (i + 1);
	return (int)result;

}