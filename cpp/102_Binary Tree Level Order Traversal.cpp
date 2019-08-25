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
	vector<vector<int>> levelOrder(TreeNode* root) {
		vector<vector<int>> res;
		if (!root)
			return res;

		vector<TreeNode*> todo;
		todo.push_back(root);
		while (!todo.empty()) {
			vector<TreeNode*> next;
			vector<int> ans;
			for (auto node : todo) {
				ans.push_back(node->val);
				if (node->left)
					next.push_back(node->left);
				if (node->right)
					next.push_back(node->right);
			}
			todo = next;
			res.push_back(ans);
		}
		return res;
	}
};

// using queue
class Solution {
public:
	vector<vector<int>> levelOrder(TreeNode* root) {
		vector<vector<int>> res;
		if (!root)
			return res;
		queue<TreeNode*> todo;
		TreeNode* curr;
		todo.push_back(root);
		while (!todo.empty()) {
			int n = todo.size()
			vector<int> ans;
			for (int i = 0; i < n; ++i) {
				curr = todo.front();
				todo.pop();
				ans.push_back(curr->val);
				if (curr->left)
					todo.push_back(curr->left);
				if (curr->right)
					todo.push_back(curr->right);
			}
			res.push_back(ans);
		}
		return res;
	}
};


// DFS recursion: shared variable res
class Solution {
public:
	vector<vector<int>> res;
	void recursion(TreeNode* node, int depth) {
		if (!root)
			return;
		if (depth >= res.size())
			res.push(vector<int>());
		res[depth].push_back(node->val);
		recursion(node->left, depth + 1);
		recursion(node->right, depth + 1);
	}
	vector<vector<int>> levelOrder(TreeNode* root) {
		if (!root)
			return res;
		recursion(root, 0);
		return res;
	}
};