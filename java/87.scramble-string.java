import java.util.Arrays;

/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */
// class Solution {
//     public boolean isScramble(String s1, String s2) {
//         if (s1.length() != s2.length())
//             return false;
//         if (s1.equals(s2))
//             return true;
//         int[] letters = new int[26];
//         for (int i = 0; i < s1.length(); i++) {
//             letters[s1.charAt(i) - 'a']++;
//             letters[s2.charAt(i) - 'a']--;
//         }
//         for (int n : letters) {
//             if (n != 0)
//                 return false;
//         }
//         for (int i = 1; i < s1.length(); i++) {
//             // Cut the two string at i and check if each part is scrambled
//             if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
//                 return true;
//             }
//             // check isScrambled for (s1.left and s2.right) and (s1.right and s2.left)
//             if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
//                     && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// DP
// dp[i][j][len] indicate whether s1[i:i+len-1] and s1[j:j+len-1] (len is length of substring) is scramble
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1)
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    else {
                        for (int k = 1; k < len; k++) {
                            if ((dp[i][j][k] && dp[i + k][j + k][len - k])
                                    || (dp[i][j + len - k][k] && dp[i + k][j][len - k]))
                                dp[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
