// dp
// if s[i] == p[j] || p[j] == '.': dp[i][j] = dp[i-1][j-1]
// if p[j] == '*':
// 		if p[j-1] != s[i]: dp[i][j] = dp[i][j-2]
// 		if p[j-1] == s[i] || p[j-1] = '.: dp[i][j] = dp[i-1][j] // a* as multiple a
// 												  || dp[i][j-1] // a* as single a
// 												  || dp[i][j-2] // a* as 0 a
class Solution {
public:
	bool isMatch(string s, string p) {
		if (!p.size())
			return !s.size();
		vector<vector<bool>> dp(s.size() + 1, vector<bool>(p.size() + 1, false));
		dp[0][0] = true;
		for (int j = 0; j < p.size(); ++j) {
			if (p[j] == '*' && j > 0 && dp[0][j - 1]) {
				dp[0][j + 1] = true;
			}
		}
		for (int i = 0; i < s.size(); ++i) {
			for (int j = 0; j < p.size(); ++j) {
				if (s[i] == p[j] || p[j] == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p[j] == '*') {
					if (j > 0 && p[j - 1] != s[i]) {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					}
					if (j > 0 && (p[j - 1] == s[i] || p[j - 1] == '.')) {
						dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
					}
				}
			}
		}
        // for(int i = 0; i <= s.size(); ++i){
        //     for(int j = 0; j <= p.size(); ++j){
        //         cout << dp[i][j];
        //     }
        //     cout << endl;
        // }
		return dp[s.size()][p.size()];
	}
};