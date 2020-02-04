/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0)
            return null;
        return helper(0, inorder.length, inorder, 0, postorder.length, postorder);

    }

    private TreeNode helper(int inBegin, int inEnd, int[] inorder, int postBegin, int postEnd, int[] postorder) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        int i = inBegin;
        for (; i < inEnd; i++) {
            if (inorder[i] == root.val)
                break;
        }
        int leftLen = i - inBegin;
        root.left = helper(inBegin, i, inorder, postBegin, postBegin + leftLen, postorder);
        root.right = helper(i + 1, inEnd, inorder, postBegin + leftLen, postEnd - 1, postorder);
        return root;
    }
}
// @lc code=end
