class Solution {
	public boolean isPalindrome(String str) {
		if (str == null || str.length() <= 1)
			return true;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				s.append(str.charAt(i));
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				s.append((char)(str.charAt(i) + 'a' - 'A'));
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
				s.append(str.charAt(i));
		}
		return isPalindromeHelper(s);
	}

	private boolean isPalindromeHelper(StringBuilder s) {
		int lo = 0, hi = s.length() - 1;
		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi))
				return false;
			lo++;
			hi--;
		}
		return true;
	}
}

public static boolean isPalindrome(String s) {
	String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	return new StringBuffer(str).reverse().toString().equals(str);
}