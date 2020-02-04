import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        s.replaceAll("\\s+", "");
        Deque<Integer> stack = new LinkedList<>();
        int res = 0, num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                // a num ends
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                // a num ends
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // push res and sign into stack
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                // a number ends
                res += sign * num;
                num = 0;
                // now res is the resule within the ()
                res *= stack.pop(); // the sign before this ()
                res += stack.pop(); // previous result before this ()
            }
        }
        // the last number
        res += sign * num;
        return res;
    }
}
// @lc code=end
