class Solution {
	public List<Integer> getRow(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			res.add(0, 1);
			for (int j = 0; j < res.size() - 1; ++j) {
				res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		res.add(0, 1);
		return res;
	}
}

class Solution {
	public List<Integer> getRow(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for (int i = 0; i < n; ++i) {
			for (int j = res.size() - 1; j > 0; --j) {
				res.set(j, res.get(j) + res.get(j - 1));
			}
			res.add(1);
		}
		return res;
	}
}

// O(k):
// row k of Pascal's Triangle: [C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
// C[k,i] = C[k,i-1]*(k-i+1)/i
class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(0, 1);
		for (int i = 1; i <= rowIndex; i++) {
			row.add(i, (row.get(i - 1)) * (rowIndex - i + 1) / i);
		}
		return row;
	}
}