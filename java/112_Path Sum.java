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
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}

// iterative: post-order traversal
// using stack
class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return false;
		stack.push(root);
		TreeNode pre = null;
		int target = 0;
		while (!stack.empty()) {
			TreeNode top = stack.peek();
			//第一次访问
			if (pre == null || (pre != top.left && pre != top.right)) {
				target += top.val;
				if (top.right != null) stack.push(top.right);
				if (top.left != null) stack.push(top.left);
			} else {
				// pre == top.left || pre == top.right
				pre = top;
				stack.pop();
				target -= top.val;
			}
			if (top.left == null && top.right == null) {
				// leaf node, check sum
				if (target == sum) return true;
				pre = top;
				stack.pop();
				target -= top.val;
			}
		}
		return false;
	}
}