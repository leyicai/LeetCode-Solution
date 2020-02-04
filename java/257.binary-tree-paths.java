/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        StringBuilder path = new StringBuilder();
        path.append(Integer.toString(root.val));
        binaryTreePathsHelper(root, path, res);
        return res;
    }

    private void binaryTreePathsHelper(TreeNode root, StringBuilder path, List<String> res) {
        if (root.left == null && root.right == null) {
            // leaf node
            res.add(path.toString());
            return;
        }
        if (root.left != null) {
            StringBuilder leftPath = new StringBuilder(path);
            leftPath.append("->" + Integer.toString(root.left.val));
            binaryTreePathsHelper(root.left, leftPath, res);
        }
        if (root.right != null) {
            StringBuilder rightPath = new StringBuilder(path);
            rightPath.append("->" + Integer.toString(root.right.val));
            binaryTreePathsHelper(root.right, rightPath, res);
        }
    }

    // iterative
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        queue.add(root);
        paths.add(Integer.toString(root.val));
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            String path = paths.poll();
            if (curr.left == null && curr.right == null) {
                res.add(path);
                continue;
            }
            if (curr.left != null) {
                queue.add(curr.left);
                paths.add(path + "->" + Integer.toString(curr.left.val));
            }
            if (curr.right != null) {
                queue.add(curr.right);
                paths.add(path + "->" + Integer.toString(curr.right.val));
            }
        }
        return res;
    }
}
// @lc code=end
