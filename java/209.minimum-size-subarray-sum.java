/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
// class Solution {
//     public int minSubArrayLen(int s, int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 0;
//         if (nums.length == 1) {
//             return nums[0] >= s ? 1 : 0;
//         }
//         int l = 0, r = 0;
//         int sum = nums[0], res = nums.length + 1;
//         while (l <= r && r < nums.length) {
//             if (sum >= s) {
//                 res = Math.min(res, r - l + 1);
//                 sum -= nums[l];
//                 l++;
//             } else {
//                 r++;
//                 if (r >= nums.length)
//                     break;
//                 sum += nums[r];

//             }
//         }
//         System.out.println(l + " " + r);
//         return res > nums.length ? 0 : res;
//     }
// }

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int l = 0, r = 0;
        int sum = 0, res = nums.length + 1;
        while (r < nums.length) {
            sum += nums[r++];
            while(sum >= s){
                res = Math.min(r - l, res);
                sum -= nums[l++];
            }
        }
        return res > nums.length ? 0 : res;
    }
}
