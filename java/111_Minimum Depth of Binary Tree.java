/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	private int minDepth = Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root, 1);
		return minDepth;
	}
	private void dfs(TreeNode node, int depth) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			minDepth = Math.min(minDepth, depth);
			return;
		}
		dfs(node.left, depth + 1);
		dfs(node.right, depth + 1);
	}
}
//add the smaller one of the child depths - except if that's zero
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        //if left == 0, return right+1
        //else the minDepth of current node is min(left, right)+1
    }
}