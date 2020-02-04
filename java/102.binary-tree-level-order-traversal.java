import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                curr = stack.removeFirst();
                if (curr != null) {
                    level.add(curr.val);
                    if (curr.left != null)
                        stack.addLast(curr.left);
                    if (curr.right != null)
                        stack.addLast(curr.right);
                }
            }
            if (level.size() > 0)
                res.add(level);
        }
        return res;
    }

    // recursion
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int level) {
        if (node == null)
            return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}
// @lc code=end
