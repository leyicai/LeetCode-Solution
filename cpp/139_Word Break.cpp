// Brute Force Time exceed
class Solution {
public:
	bool wordBreak(string s, vector<string>& wordDict) {
		return wordBreakHelper(s, wordDict);
	}
	bool wordBreakHelper(string s, vector<string>& dict) {
		if (s.size() <= 0) {
			return true;
		}
		for (int i = 1; i <= s.size(); ++i) {
			string sub = s.substr(0, i);
			if (find(dict.begin(), dict.end(), sub) != dict.end()) {
				bool right = wordBreak(s.substr(i, s.size()), dict);
				if (right)
					return true;
			}
		}
		return false;
	}
};

//dp
class Solution {
public:
	bool wordBreak(string s, vector<string>& dict) {
		int n = s.size() + 1;
		bool dp[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; ++i) {
			dp[i] = false;
			for (int j = i - 1; j >= 0; --j) {
				if (dp[j]) {
					string word = s.substr(j, i - j);
					if (find(dict.begin(), dict.end(), word) != dict.end()) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[n];
	}
};

// bfs
// each node is the index of string. 0->5 means substr(0,5) is in dict
// use bfs to find a path from 0 to s.size()
class Solution {
public:
	bool wordBreak(string s, vector<string>& dict) {
		int n = s.size();
		queue<int> q;
		vector<bool> visit(n + 1, false);
		q.push(0);
		visit[0] = true;
		while (q.size()) {
			int curr = q.front();
			q.pop();
			for (int j = curr; j < n; ++j) {
				string word = s.substr(curr, j - curr + 1);
				if (!visit[j + 1] && find(dict.begin(), dict.end(), word) != dict.end()) {
					if (j == n - 1) {
						return true;
					}
					q.push(j + 1);
					visit[j + 1] = true;
				}
			}
		}
		return false;
	}
};