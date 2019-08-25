class Solution {
public:
	string convertToTitle(int n) {
		if (n == 0) {
			return "";
		}
		else {
			return convertToTitle((n - 1) / 26) + (char)('A' + (n - 1) % 26);
		}
	}
};

// iterative:
class Solution {
public:
	string convertToTitle(int n) {
		string res;
		while (n) {
			n--;
			res += 'A' + n % 26;
			n /= 26;
		}
		return res;
	}
};