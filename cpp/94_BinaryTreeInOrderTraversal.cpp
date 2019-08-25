/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// in-order: left - root - right
class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> res;
		if (root == NULL) return res;
		stack<TreeNode*> stack;

		TreeNode* p_current = root;
		while (!stack.empty() || p_current) {
			if (p_current) {
				stack.push(p_current);
				p_current = p_current->left;
			}
			else {
				p_current = stack.top();
				stack.pop();
				res.push_back(p_current->val);
				p_current = p_current->right;
			}
		}
		return res;
	}
};

// recursion version
class Solution {
private:
	void recursion(TreeNode* node, vector<int> &res) {
		if (!node) return;
		recursion(node->left, res);
		res.push_back(node->val);
		recursion(node->right, res);
	}
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> res;
		recursion(root, res);
		return res;
	}

};
