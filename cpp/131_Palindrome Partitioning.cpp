class Solution {
public:
	vector<vector<string>> partition(string s) {
		vector<vector<string>> res;
		if (s.empty())
			return res;
		vector<string> ans;
		dfs(s, 0, ans, res);
		return res;
	}
	void dfs(string s, int idx, vector<string>& ans, vector<vector<string>>& res) {
		if (idx >= s.length()) {
			res.push_back(ans);
			return;
		}
		for (int i = idx; i < s.length(); ++i) {
			if (isPalindrome(s, idx, i)) {
				ans.push_back(s.substr(idx, i - idx + 1));
				dfs(s, i + 1, ans, res);
				ans.pop_back();
			}
		}
	}

	bool isPalindrome(string s, int l, int h) {
		while (l < h) {
			if (s[l++] != s[h--])
				return false;
		}
		return true;
	}
};

// DFS + DP
// dp[i][j] indicate if s[i]~s[j] is palindrome
// dp[i][j] = T if s[i] == s[j] && (i == j || i = j+1 || i = j+2 || dp[i+1][j-1] == T)
class Solution {
public:
	vector<vector<string>> partition(string s) {
		vector<vector<string>> res;
		if (s.empty())
			return res;
		int n = s.length();
		vector<vector<bool>> dp(n, vector<bool>(n, false));
		for (int j = 0; j < n; ++j) {
			for (int i = 0; i <= j; ++i) {
				if (s[i] == s[j] && j <= i + 2 || dp[i + 1][j - 1]) {
					dp[i][j] = true;
				}
			}
		}

		vector<string> ans;
		dfs(s, 0, dp, ans, res);
		return res;
	}
	void dfs(string s, int idx, vector<vector<bool>> dp, vector<string>& ans, vector<vector<string>>& res) {
		if (idx >= s.length()) {
			res.push_back(ans);
			return;
		}
		for (int i = idx; i < s.length(); ++i) {
			if (dp[idx][i]) {
				ans.push_back(s.substr(idx, i - idx + 1));
				dfs(s, i + 1, ans, res);
				ans.pop_back();
			}
		}
	}
};