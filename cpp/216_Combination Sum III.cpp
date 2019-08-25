class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> ans;
        int sum = 0;
        backtrack(res, ans, k, n, sum, 1);

        return res;
    }
private:
	void backtrack(vector<vector<int>> &res, vector<int> &ans, int k, int n, int &sum, int start){
		
		if(ans.size() == k){
			if(sum == n)
				res.push_back(ans);
			return;
		}
		for(int i = start; i < 10; i++){
			ans.push_back(i);
			sum += i;
			backtrack(res, ans, k, n, sum, i+1);
			ans.pop_back();
			sum -= i;
		}
	}
};