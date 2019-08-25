// 1. DP
// O(n^2) O(n^2)
class Solution {
	public String longestPalindrome(String s) {
		String res = "";
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {	// reverse. for using dp[i+1][j-1]
			for (int j = i; j < n; j++) {
				if (i == j || j == i + 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j)));
				}

				if (dp[i][j] && (j - i + 1) > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}
}
// 2. Expand around center
// O(n^2) O(1)
class Solution {
	public String longestPalindrome(String s) {
        if(s == null || s.length() < 1)
            return "";
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i++){
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
            //System.out.println(len1 + " " + len2);
			int len = Math.max(len1, len2);
			if(len > end - start){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	private int expandAroundCenter(String s, int start, int end) {
		int l = start, h = end;
		while(l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)){
			l--;
			h++;
		}
		return h - l - 1;
	}
}