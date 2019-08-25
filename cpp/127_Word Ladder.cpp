class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		unordered_set<string> set(wordList.begin(), wordList.end());
		queue<string> todo;
		todo.push(beginWord);
		int res = 1;
		while (!todo.empty()) {
			int n = todo.size();
			for (int i = 0; i < n; i++) {
				string word = todo.front(); todo.pop();
				if (word == endWord) {
					return res;
				}
				//else erase from set
				//find the next possible word ladder
				//push it into queue
				set.erase(word);
				for (int j = 0; j < size(); ++j) {
					char c = word[j];
					// substitute word[j] with other letters
					for (int k = 0; k < 26; ++k) {
						word[j] = 'a' + k;
						if (set.find(word) != set.end()) {
							//a valid ladder
							todo.push(word);
						}
					}
					word[j] = c;
				}
			}
			res++;	//res is also the level of BFS
		}
		return 0;	//not found
	}
};

// two end BFS
class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		unordered_set<string> dict(wordList.begin(), wordList.end());
		unordered_set<string> beginSet, endSet, *set1, *set2;
		if (dict.find(endWord) == dict.end())
			return 0;
		beginSet.insert(beginWord);
		endSet.insert(endWord);

		int res = 2;
		while (!beginSet.empty() && !endSet.empty()) {
			if (beginSet.size() > endSet.size()) {
				swap(beginSet, endSet);
				// make the size of two sets close
				// always explore the smaller set
			}
			unordered_set<string> tmpSet;
			for (auto it = beginSet.begin(); it != beginSet.end(); ++it) {
				string word = *it;
				for (int j = 0; j < word.size(); ++j) {
					char c = word[j];
					for (int k = 0; k < 26; ++k) {
						word[j] = 'a' + k;
						if (endSet.find(word) != endSet.end()) {
							return res;
						}
						if (dict.find(word) != dict.end()) {
							tmpSet.insert(word);
							dict.erase(word);
						}
					}
					word[j] = c;
				}
			}
			swap(beginSet, tmpSet);	//tmpSet become the new beginSet
			res++;
		}
		return 0;	//not found
	}
};