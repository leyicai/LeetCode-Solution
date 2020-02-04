/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            j--;
            i++;
        }
    }
}
