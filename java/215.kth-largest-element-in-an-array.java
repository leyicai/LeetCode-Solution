/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (i >= k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// use idea of partition in quick sort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // convert index for kth largest
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // partition nums[l:r] with pivot nums[l]
            // such that left<pivot and right>=pivot
            int pivot = l;
            for (int j = l + 1; j <= r; j++) {
                if (nums[j] < nums[l]) {
                    swap(nums, j, ++pivot);
                }
            }
            swap(nums, l, pivot);
            if (pivot == k) {
                return nums[k];
            } else if (pivot > k) {
                // pivot too large; find in the left
                r = pivot - 1;
            } else {
                // pivot too small; find in the right
                l = pivot + 1;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
