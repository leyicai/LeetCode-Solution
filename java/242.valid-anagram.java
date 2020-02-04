/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int n : map) {
            if (n != 0)
                return false;
        }
        return true;
    }
}
