// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

class Solution {
public:
	int romanToInt(string s) {
		int res = 0;
		for (auto it = s.begin(); it != s.end(); it++) {
			if (*it == 'I') {
				if (*(it + 1) == 'V' || *(it + 1) == 'X') {
					res -= 1;
				}
				else res += 1;
			}
			else if (*it == 'V') {
				res += 5;
			}
			else if (*it == 'X') {
				if (*(it + 1) == 'L' || *(it + 1) == 'C') {
					res -= 10;
				}
				else res += 10;
			}
			else if (*it == 'L') {
				res += 50;
			}
			else if (*it == 'C') {
				if (*(it + 1) == 'D' || *(it + 1) == 'M') {
					res -= 100;
				}
				res += 100;
			}
			else if (*it == 'D') {
				res += 500;
			}
			else if (*it == 'M') {
				res += 1000;
			}
		}
		return res;
	}
};

// use map
int romanToInt(string s) 
{
    unordered_map<char, int> T = { { 'I' , 1 },
                                   { 'V' , 5 },
                                   { 'X' , 10 },
                                   { 'L' , 50 },
                                   { 'C' , 100 },
                                   { 'D' , 500 },
                                   { 'M' , 1000 } };
   // back to front. 
   // Roman numerals are usually written largest to smallest from front to back                  
   int sum = T[s.back()];
   for (int i = s.length() - 2; i >= 0; --i) 
   {
       if (T[s[i]] < T[s[i + 1]])
       {
           sum -= T[s[i]];
       }
       else
       {
           sum += T[s[i]];
       }
   }
   
   return sum;
}
