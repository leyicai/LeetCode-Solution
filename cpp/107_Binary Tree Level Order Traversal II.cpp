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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        DFS(root, 0, res);
        return vector<vector<int>>(res.rbegin(), res.rend());
    }
private:
	void DFS(TreeNode* node, int level, vector<vector<int>>& res) {
		if(node == NULL){
			return;
		}
		if(level == res.size()){
			// create a new level
			res.push_back(vector<int>());
		}
		res[level].push_back(node->val);
		DFS(node->left, level+1, res);
		DFS(node->right, level+1, res);
	}
};

// without reverse
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        DFS(root, 0, res);
        //return vector<vector<int>>(res.rbegin(), res.rend());
        return res;
    }
private:
	void DFS(TreeNode* node, int level, vector<vector<int>>& res) {
		if(node == NULL){
			return;
		}
		if(level == res.size()){
			// create a new level
			res.insert(res.begin(), vector<int>());
		}
		res[res.size() - level - 1].push_back(node->val);
		DFS(node->left, level+1, res);
		DFS(node->right, level+1, res);
	}
};