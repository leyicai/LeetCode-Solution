class Solution {
public:
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> res;
		vector<string> nQueens(n, string(n, '.'));
		vector<int> flag_col(n, 1), flag_45(2 * n - 1, 1), flag_135(2 * n - 1, 1);
		N_Queens(res, nQueens, flag_col, flag_45, flag_135, 0, n);
		return res;
	}
private:
	void N_Queens(vector<vector<string>> &res, vector<string> &nQueens, vector<int> &flag_col, vector<int> &flag_45, vector<int> &flag_135, int i, int n) {
		if (i == n) {
			res.push_back(nQueens);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (flag_col[j] && flag_45[i + j] && flag_135[i - j + n - 1]) {
				nQueens[i][j] = 'Q';
				flag_col[j] = flag_45[i + j] = flag_135[i - j + n - 1] = 0;
				N_Queens(res, nQueens, flag_col, flag_45, flag_135, i + 1, n);

				//Or, nQueens[i][j] cannot be set as "Q"
				nQueens[i][j] = '.';
				flag_col[j] = flag_45[i + j] = flag_135[i - j + n - 1] = 1;
			}
		}

	}
};