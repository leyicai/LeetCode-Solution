class Solution {
public:
    void reverseString(vector<char>& s) {
        int i, j;
        i = 0; j = s.size() - 1;
        while(i < j){
            swap(s[i], s[j]);
            i++;
            j--;
        }
    }
};

class Solution {
public:
    void reverseString(vector<char>& s) {
        reverse(s.begin(), s.end());
    }
};