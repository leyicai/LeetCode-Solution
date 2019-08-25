class Solution {
public:
	vector<int> singleNumber(vector<int>& nums) {
		vector<int> res = {0, 0};
		int diff = 0;
		for (auto i : nums) {
			diff ^= i;
		}
		diff &= -diff;
		cout << diff << endl;
		for (auto i : nums) {
			if (i & diff) {
				res[0] ^= i;
			}
			else {
				res[1] ^= i;
			}
		}
		return res;
	}
};


// Using XOR
class Solution
{
public:
	vector<int> singleNumber(vector<int>& nums)
	{
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = accumulate(nums.begin(), nums.end(), 0, bit_xor<int>());
		// Get a number with only 1 bit set to 1 and others are 0, the i indicates the rightmost position that a and b differs from each other
		// e.g. a=3(0011), b=5(0101), diff=(0110). -diff=(1010)
		// diff & -diff = 0010
		diff &= -diff;

		// Pass 2 :
		vector<int> rets = {0, 0}; // this vector stores the two numbers we will return
		for (int num : nums)
		{
			if ((num & diff) == 0) // numbers with i-th pos set to 0 括号不能少！！！
			{
				rets[0] ^= num;
			}
			else // numbers with i-th pos set to 1
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}
};