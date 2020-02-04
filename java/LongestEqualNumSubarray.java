import java.util.HashMap;

class LongestEqualNumSubarray {
    public static int longestEqualSubarray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        int maxLen = -1;
        int sumLeft = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sumLeft += nums[i];
            if (sumLeft == 0) {
                // subarray[0:i] has equal 0 and 1
                maxLen = i;
            }
            if (map.containsKey(sumLeft)) {
                if (maxLen < i - map.get(sumLeft)) {
                    maxLen = i - map.get(sumLeft);
                }
            } else {
                map.put(sumLeft, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] { 0, 0, 1, 1, 0 };
        System.out.println("stouperwer".compareTo("superpower"));
        // System.out.println(longestEqualSubarray(nums));
        System.out.println("jbkkihjsmfoftph".compareTo("jbsmfoftphkkihj"));
        System.out.println("enboussvswsbeljammazyppzyiydnc".compareTo("eounbvszsswsbeljammayppzyiydnc"));

    }
}