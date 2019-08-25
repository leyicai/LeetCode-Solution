class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        int ans = 0;
        unordered_map<char, int> map;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.find(s[j]) != map.end()) {
                i = max(i, map[s[j]]);
            }
            ans = max(ans, j - i + 1);
            map[s[j]] = j + 1;
        }
        return ans;
    }
};

int lengthOfLongestSubstring(string s) {
    vector<int> dict(256, -1);
    int maxLen = 0, start = -1;
    for (int i = 0; i != s.length(); i++) {
        if (dict[s[i]] > start)
            start = dict[s[i]];
        dict[s[i]] = i;
        maxLen = max(maxLen, i - start);
    }
    return maxLen;
}