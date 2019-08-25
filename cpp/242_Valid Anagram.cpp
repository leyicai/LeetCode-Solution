class Solution {
public:
	bool isAnagram(string s, string t) {
		sort(s.begin(), s.end());
		sort(t.begin(), t.end());
		if(s.compare(t)==0) return true;
		return false;
	}
};

//Hash Table
class Solution {
public:
	bool isAnagram(string s, string t) {
		if(s.size() != t.size()) return false;
		unordered_map<char,int> map;
		for(int i = 0; i < s.size(); i++){
			map[s[i]]++;
			map[t[i]]--;
		}
		for(auto i : map){
			if(i.second != 0) return false;
		}
		return true;
	}
};
