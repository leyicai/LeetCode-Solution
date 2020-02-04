import java.util.Arrays;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1)
                    res++;
            } else {
                if (map.containsKey(entry.getKey() + k))
                    res++;
            }
        }
        return res;
    }
}

// two pointer
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (j = Math.max(i + 1, j); j < nums.length && nums[j] - nums[i] < k; j++)
                ;
            if (j < nums.length && nums[j] - nums[i] == k)
                res++;
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return res;
    }
}
