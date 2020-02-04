import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    // iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                // keep push left children
                stack.push(curr);
                curr = curr.left;
            }
            // add parent
            curr = stack.pop();
            ret.add(curr.val);
            // go to right side
            curr = curr.right;
        }
        return ret;
    }
}
// @lc code=end
