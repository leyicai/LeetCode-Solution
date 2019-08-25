// dp
// if s[i] == p[j] || p[j] == '?': dp[i][j] = dp[i-1][j-1]
// if p[j] == '*':
// 		dp[i][j] = dp[i-1][j] // * as empty seq
// 				|| dp[i][j-1] // * as any seq
class Solution {
public:
	bool isMatch(string s, string p) {
		if (!p.size())
			return !s.size();
		vector<vector<bool>> dp(s.size() + 1, vector<bool>(p.size() + 1, false));
		dp[0][0] = true;
		for (int j = 0; j < p.size(); ++j) {
			if (p[j] == '*') {
				dp[0][j + 1] = dp[0][j];
			}
		}
		for (int i = 0; i < s.size(); ++i) {
			for (int j = 0; j < p.size(); ++j) {
				if (s[i] == p[j] || p[j] == '?') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p[j] == '*') {
					dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
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

// optimize to 1D dp array: record val of dp[][j-1] for dp[][j]
// if s[i] == p[j] || p[j] == '?': dp[i][j] = dp[i-1][j-1]
// if p[j] == '*':
// 		dp[i][j] = dp[i-1][j] // * as empty seq
//
class Solution {
public:
	bool isMatch(string s, string p) {
		if (!p.size())
			return !s.size();
		vector<bool> dp(p.size() + 1, false);
		dp[0] = true;
		for (int j = 0; j < p.size(); ++j) {
			if (p[j] == '*') {
				dp[j + 1] = dp[j];
			}
			cout << dp[j + 1];
		}
		cout << endl;
		for (int i = 0; i < s.size(); ++i) {
			bool prev = dp[0];
			for (int j = 0; j < p.size(); ++j) {
				bool curr = dp[j + 1];
				if (s[i] == p[j] || p[j] == '?') {
					dp[j + 1] = prev;
				}
				else if (p[j] == '*') {
					dp[j + 1] = dp[j] || dp[j + 1];
				}
				else dp[j + 1] = false;
				prev = curr;

			}
			dp[0] = false;
			for (int j = 0; j <= p.size(); ++j) {
				cout << dp[j];
			}
			cout << endl;
		}
		return dp[p.size()];
	}
};

// iterative
// save pos of "*" we met.
bool isMatch(string s, string p) {
	int i = 0, j = 0, matchIdx = 0, starIdx = -1;
	while (i < s.size()) {
		if (j < p.size() && (p[j] == '?' || p[j] == s[i])) {
			// a match char
			i++;
			j++;
		}
		else if (j < p.size() && p[j] == '*') {
			// record the pos of *, use * to match s[i]
			starIdx = j;
			matchIdx = i;
			j++;
		}
		else if (starIdx != -1) {
			// use previous * to match this char
			j = starIdx + 1;
			matchIdx++;
			i = matchIdx;
		}
		else return false;
	}
	while (j < p.size() && p[j] == '*') {
		// extra * at end as empty seq
		j++;
	}
	return j == p.size();
}

// recursive
class Solution {
private:
	bool helper(string s, string p, int i, int j, int& starNum) {
		bool first = true;	// a flag to indicate whether incre starNum; each layer only incre once
		int currNum = starNum;
		while (i < s.size() && (p[j] == s[i] || p[j] == '?')) {
			i++;
			j++;
		}
		if (j == p.size()) {
			// p reached the end
			return i == s.size();
		}
		if (p[j] == '*') {
			while (p[j] == '*') {
				// skip consecutive *
				j++;
			}
			if(j >= p.size())	// rest of p are *
				return true;
			for (int ii = i; ii < s.size(); ++ii) {
				if (p[j] != '?' && p[j] != s[i])
					continue;
				if (first) {
					starNum++;
					first = false;
				}
				if (helper(s, p, ii, j, starNum))
					return true;
				if (starNum > currNum + 1) {
					// current processed * is not the last one
					return false;
				}
			}
		}
		return false;
	}
public:
	bool isMatch(string s, string p) {
		int starNum = 0;
		return helper(s, p, 0, 0, starNum);
	}
};