class Solution {
public:
	string convert(string s, int numRows) {
		int n = s.length();
		if (n <= 1 || numRows <= 1)
			return s;
		string res;
		for (int i = 0; i < numRows; i ++) {
			for (int j = 0; j + i < n; j += 2 * (numRows - 1)) {
				res.push_back(s[i + j]);
				if (i == numRows - 1 || i == 0) {
					continue;
				}
				if (2 * (numRows - 1) - i + j < n) {
					res.push_back(s[2 * (numRows - 1) - i + j]);
				}
			}
		}
		return res;
	}
};