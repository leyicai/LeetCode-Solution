/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || (i < nums.length && nums[i] != nums[i - 1] + 1)) {
                if (start == nums[i - 1]) {
                    res.add(Integer.toString(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                start = i != nums.length ? nums[i] : 0;
            }
        }
        return res;
    }
}
