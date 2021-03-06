/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    // index not found.
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

            }
        }
    }
}
