class Solution {
public:
	vector<string> fullJustify(vector<string>& words, int maxWidth) {
		vector <string> res;
		int len = 0, n = words.size(), i;
		string ans;
		while (i < n) {
			int j = i + 1;
			while (len + words[j].length() + (j - i) <= maxWidth) {
				//j-i is the min #space
				len += words[j].length();
				j++;
			}
			// space
			int space, mod;
			if(j - i == 1){
				//only one word
				space = maxWidth - len - 1;
				mod = 0;
			}
			else{
				space = (maxWidth - len) / (j - i);	//#spaces
				mod = (maxWidth - len) % (j - i);		//for extra space
			}
			while (i < j) {
				ans.append(words[i]);
				ans.append(space, ' ');
				if (j - i < mod)
					ans.append(1, ' ');
				i++;
			}
			res.push_back(ans);
			ans.clear();
			len = 0;
		}
		return res;
	}
};