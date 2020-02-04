import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */
// O(nlogn)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int even = (n - 1) / 2, odd = n - 1;
        for (int i = 0; i < n; i++) {
            nums[i] = i % 2 == 0 ? copy[even--] : copy[odd--];
        }
    }
}
