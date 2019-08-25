// cumulate water of each bin(width=1)
// fill the part with lower height
class Solution {
public:
	int trap(vector<int>& height) {
		int lo, hi, res, maxLo, maxHi;
		lo = 0; hi = height.size() - 1;
		res = 0;
		maxLo = 0; maxHi = 0;
		while (lo <= hi) {
			if (height[lo] <= height[hi]) {
				if (height[lo] > maxLo) {
					maxLo = height[lo];
				}
				else
					res += maxLo - height[lo];
				lo++;
			}
			else {
				if (height[hi] > maxHi) {
					maxHi = height[hi];
				}
				else
					res += maxHi - height[hi];
				hi--;
			}
		}
		return res;
	}
};