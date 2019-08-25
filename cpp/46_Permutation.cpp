class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res(1, vector<int>());
        res[0].push_back(nums[0]);
        for(int i = 1; i < nums.size(); i++){
        	vector<vector<int>> temp_res(res);
        	res.clear();
        	for(int j = 0; j < temp_res.size(); j++){
        		for(int k = 0; k <= temp_res[j].size(); k++){
        			vector<int> new_ans(temp_res[j]);
        			new_ans.insert(new_ans.begin() + k, nums[i]);
        			res.push_back(new_ans);
        		}
        	}
        }
        return res;
    }
};

//recursive version
//nums[0,..., begin-1] are fixed, then permute nums[begin,...,end]
//permute by swapping begin and following ones
class Solution {
public:
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> res;
		permute_recursive(nums, 0, res);
		return res;
	}
private:
	void permute_recursive(vector<int>& nums, int begin, vector<vector<int>>& res){
		if(begin >= nums.size()){
			res.push_back(nums);
			return;
		}

		for(int i = begin; i < nums.size(); i++){
			swap(nums[i], nums[begin]);
			permute_recursive(nums, begin+1, res);
			swap(nums[i], nums[begin]);
		}
	}
};