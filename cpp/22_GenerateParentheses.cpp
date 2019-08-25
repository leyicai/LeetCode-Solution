class Solution {
public:
	vector<string> generateParenthesis(int n) {
		vector<string> res;
		add_par(res, "", n, n);
		return res;
	}
private:
	void add_par(vector<string>& res, string s, int left, int right) {
		if (left == 0 && right == 0) {
			res.push_back(s);
			return;
		}
		if (left > 0 && left <= right) {
			add_par(res, s + '(', left - 1, right);
		}
		if (right > 0 && right >= left) {
			add_par(res, s + ')', left, right - 1);
		}
	}
};