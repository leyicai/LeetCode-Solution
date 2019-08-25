class Solution {
	public boolean isValidSudoku(char[][] b) {
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (b[i][j] != '.') {
					if (!seen.add("row" + (char)i + b[i][j]) ||
					    !seen.add("col" + (char)j + b[i][j]) ||
					    !seen.add("box" + (char)(i / 3 + j / 3 * 3) + b[i][j]))
						return false;
				}
			}
		}
	}
}