class Solution {
public:
	vector<string> fizzBuzz(int n) {
		vector<string> res;
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				res.push_back("FizzBuzz");
			}
			else if (i % 3 == 0) {
				res.push_back("Fizz");
			}
			else if (i % 5 == 0) {
				res.push_back("Buzz");
			}
			else {
				res.push_back(to_string(i));
			}
		}
		return res;
	}
};

//% operation is expensive
class Solution {
public:
	vector<string> fizzBuzz(int n) {
		vector<string> res(n);
		for (int i = 1; i <= n; i++) {
			res[i - 1] = to_string(i);
		}
		for (int i = 2; i < n; i += 3) {
			res[i] = "Fizz";
		}
		for (int i = 4; i < n; i += 5) {
			res[i] = "Buzz";
		}
		for (int i = 14； i < n; i += 15) {
			res[i] = "FizzBuzz";
		}
		return res;

	}
};