/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        String res = String.join("", str);
        if (res.charAt(0) == '0') // edge case: all 0s
            return "0";
        return res;
    }
}
