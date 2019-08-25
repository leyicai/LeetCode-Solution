class Solution {
public:
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 1; j <= k && (i + j) < nums.size(); j++) {
				if (nums[i] == nums[i + j])
					return true;
			}
		}
		return false;
	}
};


//use unordered-set
//keep nums[i-k] to nums[i-1] in the set
class Solution {
public:
	bool containsNearbyDuplicate(vector<int>& nums, int k)
	{
		unordered_set<int> s;

		if (k <= 0) return false;
		if (k >= nums.size()) k = nums.size() - 1;

		for (int i = 0; i < nums.size(); i++)
		{
			if (i > k) s.erase(nums[i - k - 1]);
			if (s.find(nums[i]) != s.end()) return true;
			s.insert(nums[i]);
		}

		return false;
	}
};