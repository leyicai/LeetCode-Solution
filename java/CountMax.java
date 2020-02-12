import java.util.*;

class CountMax {
    private static int[] countMax(int[] nums, int[] q) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                dp[i] = 1;
            else if (nums[i] == nums[i + 1])
                dp[i] = dp[i + 1] + 1;
            else {
                // change nums[i] to be the maximum of nums[i:]
                // to compare with the prev numbers
                nums[i] = nums[i + 1];
                dp[i] = dp[i + 1];
            }
        }
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            res[i] = dp[q[i] - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 4, 5, 3, 5 };
        int[] q = new int[] { 1, 3, 5 };
        int[] res = countMax(nums, q);
        System.out.println(Arrays.toString(res));
    }
}