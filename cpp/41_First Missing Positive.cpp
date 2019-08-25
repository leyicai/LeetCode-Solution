// put postive n at the pos[n-1].
// if n = idx, n is not a missing positive
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        for(auto n : nums){
        	while(n > 0 && n <= nums.size() && n != nums[n-1]){
        		swap(n, nums[n-1]);
        	}
        }
        for(int i = 0; i < nums.size(); ++i){
            //cout<<nums[i];
        	if(nums[i] != i+1){
        		return i+1;
        	}
        }
        return nums.size() + 1;
    }
};