import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    ///// bfs
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (curr.left != null)
                        queue.offer(curr.left);
                    if (curr.right != null)
                        queue.offer(curr.right);
                    rowMax = Math.max(rowMax, curr.val);
                }
            }
            res.add(rowMax);
        }
        return res;
    }

    /////// dfs
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode curr, int level) {
        if (level >= res.size()) {
            res.add(Integer.MIN_VALUE);
        }
        if (curr.left != null)
            dfs(curr.left, level + 1);
        if (curr.right != null)
            dfs(curr.right, level + 1);
        int max = res.get(level);
        if (curr.val > res.get(level)) {
            res.set(level, curr.val);
        }
    }
}
// @lc code=end
