/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    // iterative
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);

        TreeNode left, right;
        while (queue.size() > 1) {
            right = queue.poll();
            left = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null ^ right == null) {
                // ^: true when one of left and right is null
                return false;
            }
            if (left.val != right.val)
                return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
// @lc code=end
