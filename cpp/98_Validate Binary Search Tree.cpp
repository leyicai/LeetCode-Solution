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
	bool isValidBST(TreeNode* root) {
		return isValidBST(root, NULL, NULL);
	}
	bool isValidBST(TreeNode* root, TreeNode* minNode, TreeNode* maxNode) {
		if (!root) {
			return true;
		}
		if (minNode && root->val <= minNode->val || maxNode && root->val >= maxNode->val) {
			return false;
		}
		return isValidBST(root->left, minNode, root) && isValidBST(root->right, root, maxNode);
	}
};

// in-order traversal
class Solution {
public:
	bool isValidBST(TreeNode* root) {
		if (!root)
			return true;
		stack<TreeNode*> stack;
		TreeNode* pre = NULL;
		while (!stack.empty() || root) {
			while (root) {
				stack.push(root);
				root = root->left;
			}
			root = stack.top();
			stack.pop();

			if (pre && pre->val >= root->val) {
				return false;
			}
			pre = root;
			root = root->right;
		}
		return true;
	}
};

// in-order recursion
class Solution {
public:
	bool isValidBST(TreeNode* root) {
        TreeNode* pre = NULL;
		return isValidBST(root, pre);
	}
	bool isValidBST(TreeNode* root, TreeNode* &pre) {	//pre must be passed by ref: update every prev, not just local pre. Think as a shared variable.
		if(!root)
			return true;
		if(!isValidBST(root->left, pre)){
			return false;
		}
		if(pre && pre->val >= root->val) {
			return false;
		}
		pre = root;
		return isValidBST(root->right, pre);
	}
};



