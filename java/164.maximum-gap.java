/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }
}

// bucket sort
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        // Get max and min of the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        // Assign buckets
        // We only care about the min and max in each bucket
        int gap = (max - min) / nums.length + 1, bucketNum = (max - min) / gap + 1;
        int[] bucketMin = new int[bucketNum];
        int[] bucketMax = new int[bucketNum];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        // Fill the buckets with numbers in array
        for (int n : nums) {
            int i = (n - min) / gap;
            bucketMin[i] = Math.min(bucketMin[i], n);
            bucketMax[i] = Math.max(bucketMax[i], n);
        }
        // Scan the buckets to get the maximum gap
        gap = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {
                gap = Math.max(gap, bucketMin[i] - min);
                min = bucketMax[i];
            }
        }
        return gap;
    }
}
