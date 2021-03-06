/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

//BFS
class Solution {
    public int jump(int[] nums) {
        int curr = 0, reach = 0, level = 0, i = 0;
        int n = nums.length;
        if (n < 2)
            return 0;
        while (i <= curr) {
            level++;
            reach = curr;
            for (; i <= curr; i++) {
                reach = Math.max(reach, i + nums[i]);
                if (reach >= n - 1)
                    return level;
            }
            curr = reach;
        }
        return 0;
    }
}

// Greedy
class Solution {
    public int jump(int[] nums) {
        int curr = 0, reach = 0, level = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            reach = Math.max(i + nums[i], reach);
            if (i == curr) {
                level++;
                curr = reach;
            }
        }
        return level;
    }
}
