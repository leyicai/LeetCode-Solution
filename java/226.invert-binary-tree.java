import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // iterative
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr, temp;
        queue.add(root);
        while (!queue.isEmpty()) {
            curr = queue.poll();
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        return root;
    }
}
// @lc code=end
