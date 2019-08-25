// if start from i stop at x, i.e. could not reach x but x-1
// for start from k = i to x-1 could not reach x
// proof: i could reach k, if k could reach x, i could reach x. Contradiction
// from i to x-1 could not be start
//
// if sum(gas) > sum(cost), has solution
//
// -> if x can reach the end && has solution, x is the result
class Solution {
public:
	int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
		int tank = 0, sum = 0, start = 0;
		for (int i = 0; i < gas.size(); ++i) {
			tank += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if (tank < 0) {
				tank = 0;
				start = i + 1;
				cout << start << endl;
			}
		}
		return sum < 0 ? -1 : start;
	}
};

// two pointer
class Solution {
public:
	int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
		int sum = 0, start, end;
		start = gas.size() - 1;
		end = 0;
        sum += gas[start] - cost[start];
		while (end < start) {
			if (sum < 0) {
                start--;
				sum += gas[start] - cost[start];
			}
			else {
				sum += gas[end] - cost[end];
                end++;
			}
		}
		return sum < 0 ? -1 : start;
	}
};