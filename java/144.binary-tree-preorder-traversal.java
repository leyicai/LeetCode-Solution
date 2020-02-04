import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr != null) {
                ret.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return ret;
    }
}
// @lc code=end
