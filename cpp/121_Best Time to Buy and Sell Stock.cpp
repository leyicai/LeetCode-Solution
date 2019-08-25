class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int res = 0;
		int minPri = INT_MAX;
		for (int i = 0; i < prices.size(); i++) {
			minPri = min(minPri, prices[i]);
			res = max((prices[i] - minPri), res);
		}
		return res;
	}
};