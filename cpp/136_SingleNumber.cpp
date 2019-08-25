class Solution {
public:
	int singleNumber(vector<int>& nums) {
		for (int i = nums.size() - 1; i >= 0; i--) {
			auto it = find(nums.begin(), nums.end(), nums[i]);
			if (it - nums.begin() == i)
				return nums[i];
			else {
				nums.erase(it);
				i--;
			}
		}
	}
};

//using XOR, XOR is commutative
//A XOR A = 0 0 XOR A = A
//A[0] XOR A[1] XOR ... XOR A[N-1]
int singleNumber(int A[], int n) {
	int result = 0;
	for (int i = 0; i < n; i++)
	{
		result ^= A[i];
	}
	return result;
}
