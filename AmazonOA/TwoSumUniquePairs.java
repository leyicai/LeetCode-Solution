import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int twoSumUniquePair(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for (int n : nums) {
            if (set.contains(target - n) && !seen.contains(n)) {
                res++;
                seen.add(n);
                seen.add(target - n);
            } else if (!set.contains(n)) {
                set.add(n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 45, 46, 2, 46 };
        int target = 47;
        System.out.println(twoSumUniquePair(nums, target));
    }
}