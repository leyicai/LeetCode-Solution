class Solution {
public:
	unordered_set<int> set;
	bool isHappy(int n) {
		if (n == 1) {
			return true;
		}
		if (n == 0) {
			return false;
		}
		int sum = 0;
		while (n) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		if (set.find(sum) != set.end()) {
			return false;
		}
		set.insert(sum);
		return isHappy(sum);
	}
};

// fast and slow ptrs
class Solution {
public:
	int digitSqrSum(int n) {
		int sum = 0;
		while (n) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

	bool isHappy(int n) {
		int fast = slow = n;
		while (1) {
			fast = digitSqrSum(fast);
			fast = digitSqrSum(fast);
			slow = digitSqrSum(slow);
			if (slow == fast)
				break;
		}
		return slow == 1;
	}
};