class Solution {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<vector<int>> res(1, vector<int>());
		for (int i = 0; i < nums.size(); i++) {
			// add nums[i] into subsets
			int n = res.size();
			for (int j = 0; j < n; j++) {
				vector<int> new_ans(res[j]);
				new_ans.push_back(nums[i]);
				res.push_back(new_ans);
			}
		}
		return result;
	}
};


// backtrack
class Solution {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<vector<int>> res(1, vector<int>());
		vector<int> temp;
		backtrack(res, temp, nums, 0);
		return res;
	}
private:
	void backtrack(vector<vector<int>> &res, vector<int> &temp, vector<int> &nums, int index) {
		res.push_back(temp);
		for (int i = index; i < nums.size(); i++) {
			temp.push_back(nums[i]);
			backtrack(res, temp, nums, i + 1);
			temp.pop_back();
		}
	}
};