/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() {}

    Node(int _val, Node* _left, Node* _right, Node* _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
public:
    Node* connect(Node* root) {
        if (!root)
            return NULL;
        queue<Node*> queue;
        queue.push(root);
        Node* pre, curr;
        while (!queue.empty()) {
            int n = queue.size() - 1;
            pre = queue.front(); queue.pop();
            if (pre->left) queue.push(pre->left);
            if (pre->right) queue.push(pre->right);
            for (int i = 0; i < n; ++i) {
                curr = queue.front(); queue.pop();
                if (curr->left) queue.push(curr->left);
                if (curr->right) queue.push(curr->right);
                pre->next = curr;
                pre = curr;
            }
        }

        return root;
    }
};

// O(1) space
class Solution {
public:
    Node* connect(Node* root) {
        Node* pre = root;
        Node* curr = NULL;
        while (pre && pre->left) {
            curr = pre;
            while (curr) {
                if (curr->left)
                    curr->left->next = curr->right;
                if (curr->next) {
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
            pre = pre->left;
        }

        return root;
    }
};

// Recursive
class Solution {
public:
    Node* connect(Node* root) {
        if (!root)
            return NULL;
        if (root->left) {
            root->left->next = root->right;
            if (root->next) {
                root->right->next = root->next->left;
            }
            connect(root->left);
            connect(root->right);
        }
        return root;
    }
};