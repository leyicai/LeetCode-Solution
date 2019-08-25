// time out when n is large
class Solution {
	public double myPow(double x, int n) {
		if (n == 0)
			return (double)1;
		if (n == 1)
			return x;
		if (n == Integer.MIN_VALUE)
			return 1.0 / x * myPow(1.0 / x, Integer.MAX_VALUE);
		if (n < 0) {
			n = -n;
			x = 1.0 /x;
		}
		double res = 1;
		while (n > 0) {
			if ((n & 1) != 0)
				res *= x;
			x *= x;
			n >>= 1;
			//System.out.println(res + " " + pow);
		}
		return res;
	}
}

class Solution {
	public double myPow(double x, int n) {
		if (n == 0)
			return (double)1;
		if (n == 1)
			return x;
		// overflow for -n when n = MIN_VALUE
		if (n == Integer.MIN_VALUE)
			return 1.0 / x * myPow(1.0 / x, Integer.MAX_VALUE);
			// return myPow(x*x, n/2)
		if (n < 0) {
			n = -n;
			x = 1.0 / x;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}