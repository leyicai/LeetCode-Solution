/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// binary search
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int lo = 1, hi = nums.length, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid)
                    cnt++;
            }
            if (cnt <= mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
