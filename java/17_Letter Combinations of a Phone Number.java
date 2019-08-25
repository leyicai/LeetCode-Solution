// 1. recursion
class Solution {
	private static HashMap<Character, String> map = new HashMap<>();

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() < 1)
			return res;

		mapInitialize();

		helper(res, digits, 0, "");
		return res;

	}

	private static void mapInitialize() {
		map.put('0', " ");
		map.put('1', "*");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

	}
	private void helper(List<String> res, String digits, int start, String ans) {
		if (ans.length() == digits.length()) {
			res.add(ans);
			return;
		}
		String letters = map.get(digits.charAt(start));
		if (letters == null) {
			return;
		}
		for (int j = 0; j < letters.length(); j++) {
			String s = ans + letters.charAt(j);
			//ans += letters.charAt(j);
			helper(res, digits, start + 1, s);
		}

	}
}

// optimize
// change HashMap into String[] map = new String[] {"", "", ......}
// use StringBuilder instead of String
class Solution {
	private String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() < 1)
			return res;

		helper(res, digits, 0, new StringBuilder());
		return res;

	}

	private void helper(List<String> res, String digits, int start, StringBuilder ans) {
		if (ans.length() == digits.length()) {
			res.add(ans.toString());
			return;
		}

		for (char c : map[digits.charAt(start) - '0'].toCharArray) {
			ans.append(c);
			helper(res, digits, start + 1, ans);
			ans.deleteCharAt(ans.length() - 1);
		}

	}
}

// 2. FIFO queue with LinkedList
// FIFO queue Order: example input "23"
// a, b, c
// b, c, ad, ae, af
// c, ad, ae, af, bd, be, bf
class Solution {
	private String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<String>();
		if (digits == null || digits.length() < 1)
			return res;

		res.add("");

		while (res.peek().length() != digits.length()) {
			String curr = ans.remove();
			String letters = map[digits.charAt(curr.length()) - '0'];
			for (char c : letter.toCharArray()) {
				res.addLast(curr + c);
			}
		}
		return res;
	}
}

// 3. Iterative
// similar to FIFO queue
class Solution {
	private String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() < 1)
			return res;

		res.add("");

		for (int i = 0; i < digits.length(); i++) {
			String letters = map[digits.charAt(i) - '0'];
			List<String> tempRes = new ArrayList<String>();
			for (String s : res) {
				for (int j = 0; j < letters.length(); j++) {
					tempRes.add(s + letters.charAt(j));
				}
			}
			res = tempRes;
		}
		return res;
	}
}