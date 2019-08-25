class Solution {
	public List<List<Integer>> generate(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n < 1)
			return res;
		res.add(new ArrayList<Integer>());
		res.get(0).add(1);
		for (int i = 1; i < n; i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			for (int j = 1; j < i; ++j) {
				int sum = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
				row.add(sum);
			}
			row.add(1);
			res.add(row);
		}
		return res;
	}
}

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);	// insert 1 at the beginning
			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;

	}
}