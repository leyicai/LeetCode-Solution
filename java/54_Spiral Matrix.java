class Solution {
	public List<Integer> spiralOrder(int[][] mat) {
		List<Integer> res = new ArrayList<>();
		if (mat == null || mat.length < 1)
			return res;
		int m = mat.length, n = mat[0].length;
		int rowBegin = 0, rowEnd = m - 1;
		int colBegin = 0, colEnd = n - 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// goes right
			for (int j = colBegin; rowBegin <= rowEnd && j <= colEnd; j++) {
				res.add(mat[rowBegin][j]);
			}
			rowBegin++;
			// goes down
			for (int i = rowBegin; colBegin <= colEnd && i <= rowEnd; i++) {
				res.add(mat[i][colEnd]);
			}
			colEnd--;
			// goes left
			for (int j = colEnd; rowBegin <= rowEnd && j >= colBegin; j--) {
				res.add(mat[rowEnd][j]);
			}
			rowEnd--;
			//goes up
			for (int i = rowEnd; colBegin <= colEnd && i >= rowBegin; i--) {
				res.add(mat[i][colBegin]);
			}
			colBegin++;
		}
		return res;
	}
}