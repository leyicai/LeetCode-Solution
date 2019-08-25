/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//pre-order: root - left -right
class Solution {
public:
	vector<int> preorderTraversal(TreeNode* root) {
		vector<int> res;
		if (root == NULL) return res;
		stack<TreeNode*> stack;

		TreeNode* p_current = root;
		stack.push(p_current);
		while (!stack.empty()) {
			p_current = stack.top();
			stack.pop();
			res.push_back(p_current->val);
			if (p_current->right) {
				stack.push(p_current->right);
			}
			if (p_current->left) {
				stack.push(p_current->left);
			}
		}
		return res;
	}
};