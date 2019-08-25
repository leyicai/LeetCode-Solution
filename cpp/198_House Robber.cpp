class Solution {
public:
	int rob(vector<int>& nums) {
		if (nums.size() == 1)
			return nums[0];
		if (nums.size() == 2)
			return max(nums[0], nums[1]);
		int n = nums.size();
		int dp[n + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i < n + 1; i++) {
			dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return max(dp[n], dp[n - 1]);
	}
};

// with 2 variables
class Solution {
public:
	int rob(vector<int>& nums) {
		int a = 0;		//even
		int b = 0;		//odd

		for (int i = 0; i < nums.size(); i++) {
			if (i % 2 == 0) {
				a = max(a + nums[i], b);
			}
			else {
				b = max(a, b + nums[i]);
			}
		}

		return max(a, b);
	}
};

// recursive(top-down)
class Solution {
public:
	int rob(vector<int>& nums) {
		return rob(nums, nums.size() - 1);
	}
	int rob(vector<int>& nums, int i) {
		if (i < 0)
			return 0;
		return max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}
}