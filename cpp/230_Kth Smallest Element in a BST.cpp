class Solution {
public:
	int kthSmallest(TreeNode* root, int k) {
		if (!root) return -1;
		vector<int> order;
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
				order.push_back(p_current->val);
				if (order.size() == k) {
					return order[k - 1];
				}
				p_current = p_current->right;
			}
		}
		return -1;
	}
};

//recursive
class Solution {
public:
	int kthSmallest(TreeNode* root, int& k) {
		if (root) {
			int x = kthSmallest(root->left, k);
			if (k == 0) return x;
			if (k == 1) return root->val;
			else return kthSmallest(root->right, --k);
		}
		return -1;
	}
};