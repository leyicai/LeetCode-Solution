class Solution {
public:
	bool isPalindrome(int x) {
		if (x < 0)
			return false;
		int reverse = 0, x1 = x;
		while (x1) {
			reverse = reverse * 10 + x1 % 10;
			x1 = x1 / 10;
		}
		if (reverse == x)
			return true;
		return false;
	}
};




public boolean isPalindrome(int x) {
	if (x < 0 || (x != 0 && x % 10 == 0)) 
		return false;
	int rev = 0;
	while (x > rev) {
		rev = rev * 10 + x % 10;
		x = x / 10;
	}
	return (x == rev || x == rev / 10);
	//x == rev: if x has even digits, e.g. 1221, then x = 12 and rev = 12
	//x == rev/10: if x has odd digits, e.g. 121, then x = 1 and rev = 12, where x = rev/10
}