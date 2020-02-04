/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */
class Solution {
    public String reverseVowels(String str) {
        int i = 0, j = str.length() - 1;
        char[] s = str.toCharArray();
        String vowels = "aeiouAEIOU";
        while (i < j) {
            while (i < s.length && !vowels.contains(s[i] + ""))
                i++;
            while (j >= 0 && !vowels.contains(s[j] + ""))
                j--;
            if (i >= j)
                break;
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
        return String.valueOf(s);
    }
}
