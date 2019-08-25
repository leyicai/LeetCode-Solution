class Solution {
public:
	string intToRoman(int num) {
		int nums[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		string chars[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		string res;
		for (int i = 12; i >= 0; i--) {
			while (num >= nums[i]) {
				res.append(chars[i]);
				num -= nums[i];
			}
		}
		return res;
	}
};