class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		int n = nums.size();
		unorder_map<int> map;
		for (int i = 0; i < n; i++) {
			auto search = map.find(target - nums[i]);
			if (search != map.end()) {
				return {i, search->second};
			}
			map[nums[i]] = i;
		}
	}
};