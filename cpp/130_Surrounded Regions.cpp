// BFS
// flip the elem connected to bordered-'O's to '.'
// then flip the rest 'O' to 'X' and flip '.' to 'O'
class Solution {
public:
	void solve(vector<vector<char>>& board) {
		int n, m;
		n = board.size();
		if (!n)
			return;
		m = board[0].size();
		if (!m)
			return;
		for (int i = 0; i < n; ++i) {
			check(board, i, 0, n, m);
			if (m > 1) {
				check(board, i, m - 1, n, m);
			}
		}
		for (int j = 1; j < m; ++j) {
			check(board, 0, j, n, m);
			if (n > 1) {
				check(board, n - 1, j, n, m);
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '.') {
					board[i][j] = 'O';
				}
			}
		}

	}
private:
	void check(vector<vector<char>>& board, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return;
		if (board[i][j] == 'O') {
			board[i][j] = '.';
			if (i > 1) {
				check(board, i - 1, j, n, m);
			}
			if (j > 1) {
				check(board, i, j - 1, n, m);
			}
			if (i < n - 1) {
				check(board, i + 1, j, n, m);
			}
			if (j < m - 1) {
				check(board, i, j + 1, n, m);
			}
		}
	}
};