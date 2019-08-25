class Solution {
	public int myAtoi(String str) {
		int i = 0;
		int minus = 1;
		int res = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			minus = str.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
			//overflow
			if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')
				return minus == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			res = res * 10 + (str.charAt(i) - '0');
			i++;
		}

		return res * minus;
	}
}