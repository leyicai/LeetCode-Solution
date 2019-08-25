import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
// naive HashMap
// 613ms = =
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        HashMap<Integer, Integer> pre = new HashMap<>();
        for (int n : nums) {
            pre.put(n - 1, n);
        }
        int res = 0;
        for (int n : nums) {
            int len = 0;
            while (pre.containsKey(n)) {
                n = pre.get(n);
                len++;
            }
            res = Math.max(res, len);
        }
        return res + 1;
    }
}

// With Set
// Find number with no pre, then find the consecutive sequence
// 7ms
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int i = n + 1;
                while (set.contains(i)) {
                    i++;
                }
                res = Math.max(res, i - n);
            }
        }
        return res;
    }
}

// HashMap:
// key - number
// value - length of consecutive sequence contains this number
// 7ms
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                // expand n to its left/right neighbor(if exists)
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int sum = left + right + 1; // length of seq contains n
                map.put(n, sum); // add n into map
                // update two end points of current seq
                if (left > 0)
                    map.put(n - left, sum);
                if (right > 0)
                    map.put(n + right, sum);
                // update res
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}

// update set
// remove consecutive numbers in the set
// 6ms
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            int left = n - 1, right = n + 1;
            set.remove(n);
            while (set.remove(left))
                left--;
            while (set.remove(right))
                right++;
            res = Math.max(res, right - left - 1);
            if (set.isEmpty())
                return res;
        }
        return res;
    }
}
