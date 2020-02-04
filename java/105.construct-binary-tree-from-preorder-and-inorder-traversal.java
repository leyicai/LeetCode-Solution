import MedianFinder.TreeNode;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        return helper(0, preorder.length, preorder, 0, inorder.length, inorder);
    }

    private TreeNode helper(int preBegin, int preEnd, int[] preorder, int inBegin, int inEnd, int[] inorder) {
        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        int i = inBegin;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val)
                break;
        }
        int leftLen = i - inBegin;
        root.left = helper(preBegin + 1, preBegin + 1 + leftLen, preorder, inBegin, inBegin + leftLen, inorder);
        root.right = helper(preBegin + 1 + leftLen, preEnd, preorder, i + 1, inEnd, inorder);
        return root;
    }
}
// @lc code=end
