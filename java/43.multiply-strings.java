/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] prod = new int[n + m];
        // res of num1[i] * num2[j] would be placed at [i+j, i+j+1]
        // prod[0] could be > 9. others are all between 0 and 9
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = prod[i + j] * 10 + prod[i + j + 1] + mul; // add prev results
                prod[i + j] = sum / 10;
                prod[i + j + 1] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i : prod) {
            if (res.length() == 0 && i == 0)
                continue;
            res.append(i);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
// @lc code=end
