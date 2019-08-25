/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
	bool isBalanced(TreeNode* root) {
		if (root == NULL) {
			return true;
		}
		int leftDepth, rightDepth;
		leftDepth = depth(root->left);
		rightDepth = depth(root->right);
		if (abs(leftDepth - rightDepth) > 1)
			return false;
		else
			return isBalanced(root->left) && isBalanced(root->right);
	}

	int depth(TreeNode* node) {
		if (node == NULL)
			return 0;
		return max(depth(node->left), depth(node->right)) + 1;
	}
};

// the helper function returns the height if current node is balanced
// or return -1 if not
// each node is visited only once

class Solution {
public:
	bool isBalanced(TreeNode* root) {
		return dfsHeight(root) != -1;
	}

	int dfsHeight(TreeNode* node) {
		if (node == NULL)
			return 0;

		int leftHeight, rightHeight;

		leftHeight = dfsHeight(node->left);
		if(leftHeight == -1)
			return -1;

		rightHeight = dfsHeight(node->right);
		if(rightHeight == -1)
			return -1;

		if(abs(leftHeight - rightHeight) > 1)
			return -1;

		return max(leftHeight, rightHeight) + 1;
	}
};