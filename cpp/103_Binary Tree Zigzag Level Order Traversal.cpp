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
	vector<vector<int>> res;
	void recursion(TreeNode* node, int depth) {
		if (!node)
			return;
		if (depth >= res.size()) {
			res.push_back(vector<int>());
		}
		if (depth % 2) {
			res[depth].insert(res[depth].begin(), node->val);
		}
		else {
			res[depth].push_back(node->val);
		}
		recursion(node->left, depth + 1);
		recursion(node->right, depth + 1);
	}
	vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
		recursion(root, 0);
		return res;
	}
};

// iterative: record current depth and do reverse

// w/o reverse
// at the depth needs reverse: queue [i] -> goes to -> vector[queue.size() - 1 - i]
class Solution {
public:
	vector<vector<int> > zigzagLevelOrder(TreeNode* root) {
		if (root == NULL) {
			return vector<vector<int> > ();
		}
		vector<vector<int> > result;

		queue<TreeNode*> nodesQueue;
		nodesQueue.push(root);
		bool leftToRight = true;

		while ( !nodesQueue.empty()) {
			int size = nodesQueue.size();
			vector<int> row(size);
			for (int i = 0; i < size; i++) {
				TreeNode* node = nodesQueue.front();
				nodesQueue.pop();

				// find position to fill node's value
				int index = (leftToRight) ? i : (size - 1 - i);

				row[index] = node->val;
				if (node->left) {
					nodesQueue.push(node->left);
				}
				if (node->right) {
					nodesQueue.push(node->right);
				}
			}
			// after this level
			leftToRight = !leftToRight;
			result.push_back(row);
		}
		return result;
	}
}