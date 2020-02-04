import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private Map<Integer, Integer> frequency = new HashMap<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        findTreeSum(root);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == max)
                res.add(entry.getKey());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int findTreeSum(TreeNode node) {
        if (node == null)
            return 0;
        int sum = node.val + findTreeSum(node.left) + findTreeSum(node.right);
        frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
        max = Math.max(max, frequency.get(sum));
        return sum;
    }

}
// @lc code=end
