import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // find path with DFS
    // then compare the two paths
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        Deque<TreeNode> pPath = new LinkedList<>(), qPath = new LinkedList<>();
        findPath(root, q, qPath);
        findPath(root, p, pPath);
        TreeNode res;
        while (pPath.peek().val == qPath.peek().val) {
            res = pPath.pop();
            qPath.pop();
        }
        return res;
    }

    // find path from root to node
    // node must not be null
    private boolean findPath(TreeNode root, TreeNode node, Deque<TreeNode> path) {
        if (node == null || root == null)
            return false;
        if (root.val == node.val) {
            path.push(root.val);
            return true;
        }
        return findPath(root.left, node, path) || findPath(root.right, node, path);
    }

    //////////// DFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        // if both null: LCA is null
        // if one of them is null, both p q in one subtree: the other is LCA
        // if both not null: p q in two different subtree, LCA is null
        return leftLCA == null ? rightLCA : rightLCA == null ? leftLCA : root;
    }

    /////////// Find parents with BFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // BFS to store parents
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        // add ancestors of p into set
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        // find common ancestor of p and q
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
// @lc code=end
