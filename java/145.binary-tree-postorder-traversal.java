import java.util.ArrayList;
import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                // push until find the leftmost leaf
                stack.push(curr);
                if (curr.left != null)
                    curr = curr.left;
                else
                    curr = curr.right;
            }
            curr = stack.pop();
            res.add(curr.val);
            if (!stack.isEmpty() && stack.peek().left == curr) {
                // parent: stack.peek()
                // left(curr) is done, go to the right side
                curr = stack.peek().right;
            } else {
                curr = null;
            }
        }
        return ret;
    }
}
// @lc code=end
