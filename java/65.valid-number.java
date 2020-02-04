/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eSeen = false, pointSeen = false, numSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen)
                    return false;
                eSeen = true;
                numSeen = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else {
                return false;
            }
        }
        return numSeen;
    }
}
