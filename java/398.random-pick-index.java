import java.util.*;
/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start
class Solution {
    // Map<Integer, List<Integer>> map = new HashMap<>();

    // public Solution(int[] nums) {
    // for (int i = 0; i < nums.length; i++) {
    // List<Integer> indices = map.getOrDefault(nums[i], new ArrayList<>());
    // indices.add(i);
    // map.put(nums[i], indices);
    // }
    // }

    // public int pick(int target) {
    // List<Integer> indices = map.get(target);
    // int rand = new Random().nextInt(indices.size());
    // return indices.get(rand);
    // }

    // reservoir-sampling
    private int[] nums;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rand.nextInt(++count) == 0)
                res = i;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */
// @lc code=end
