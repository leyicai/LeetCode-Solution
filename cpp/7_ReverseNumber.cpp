class Solution {
public:
	int reverse(int x) {
		long long result = 0;
		while (abs(x)) {
			result = result * 10 + x % 10;
			if (result > INT_MAX || result < INT_MIN)	//check overflow
				return 0;
			x = x / 10;
		}
		return result;
	}
};