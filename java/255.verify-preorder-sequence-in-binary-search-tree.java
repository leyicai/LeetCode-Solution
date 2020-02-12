import java.util.*;
/*
 * @lc app=leetcode id=255 lang=java
 *
 * [255] Verify Preorder Sequence in Binary Search Tree
 */

// @lc code=start
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int num : preorder) {
            if (num < low)
                return false;
            while (!stack.isEmpty() && num > stack.peek()) {
                // pop from stack, find the parent of current num
                // current num is in the right subtree of low
                low = stack.pop();
            }
            stack.push(num);
        }
        return false;
    }

    ////// optimize stack to O(1) space
    // use the traversed part of preorder as a stack
    // top is the index of current top of the "stack"
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, top = -1;
        for (int num : preorder) {
            if (num < low)
                return false;
            while (top >= 0 && num > preorder[top]) {
                // "pop" stack
                low = preorder[top--];
            }
            // "push" stack
            preorder[++top] = num;
        }
        return true;
    }

}
// @lc code=end
