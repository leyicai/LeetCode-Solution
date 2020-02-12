/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        res[0] = lo < nums.length && nums[lo] == target ? lo : -1;
        if (res[0] == -1)
            return res;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        res[1] = hi < nums.length && nums[hi] == target ? hi : -1;
        return res;
    }
}
// @lc code=end
