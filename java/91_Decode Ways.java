class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1; dp[1] = 1;
		for (int i = 2; i <= s.length; i++) {
			int num1 = Integer.valueOf(s.substring(i - 1, i));	//curr digit
			int num2 = Integer.valueOf(s.substring(i - 2, i));	//curr+prev digit
			if (num1 >= 1 && num1 <= 9) {
				dp[i] += dp[i - 1];
			}
			if (num2 >= 10 && num2 <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length() - 1];
	}
}

// memoization
public class Solution {
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0) return 0;

		int[] memo = new int[n + 1];
		memo[n]  = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0') continue;
			else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}
}

// decode 1 digit:  
// decode 2 digits: 