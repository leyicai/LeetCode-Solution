import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int num = 0, res = 0;
        char sign = '+';
        Deque<Integer> stack = new LinkedList<>();
        s = s.replaceAll("\\s+", "");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                case '+':
                    stack.push(+num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(num * stack.pop());
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                default:
                    break;
                }
                sign = c;
                num = 0;
            }
        }
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }
}
// @lc code=end
