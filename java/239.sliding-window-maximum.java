/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1)
            return nums;
        // a deque to store the idx of candidate num
        // the first is always the max one
        // should only contains nums[i-k+1, i]
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                // remove idx out of range
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                // remove useless candidates
                // if nums[i] is larger, for the rest windows, the max should not be these
                // candidates
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                // add into res array
                res[j++] = nums[dq.peek()];
            }

        }
        return res;
    }
}
