class Solution {
	public int divide(int dividend, int divisor) {
		boolean sign = (dividend > 0) ^ (divisor > 0);
		// corner case overflow
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;

		if (dividend > 0)
			dividend = -dividend;
		if (divisor > 0)
			divisor = -divisor;

		int ans = divideHelper(dividend, divisor);
		return sign ? -ans : ans;
	}

	// using negative numbers to calculate
	private int divideHelper(int dividend, int divisor) {
		if (dividend > divisor)
			return 0;
		int shift = 0, rest = 0;
		while ((divisor << shift) >= dividend && (divisor << shift) < 0 && shift < 32)
			shift++;
		rest = dividend - (divisor << (shift - 1));
		if (rest > divisor)  // just to reduce one recursion
			return 1 << (shift - 1);
		return (1 << (shift - 1)) + divideHelper(rest, divisor);
	}
}