/*
 * @lc app=leetcode id=248 lang=java
 *
 * [248] Strobogrammatic Number III
 */

// @lc code=start
class Solution {
    // public int strobogrammaticInRange(String low, String high) {
    // int[] res = { 0 };
    // helper(low, high, "", res);
    // helper(low, high, "0", res);
    // helper(low, high, "1", res);
    // helper(low, high, "8", res);
    // return res[0];
    // }

    // private void helper(String low, String high, String s, int[] res) {
    // if (s.length() == high.length() && s.compareTo(high) > 0) {
    // // same length as high but larger
    // // System.out.println("return"+s);
    // return;
    // }
    // if (s.length() >= low.length() && s.length() <= high.length() && !(s.length()
    // > 1 && s.charAt(0) == '0')
    // && !(s.length() == low.length() && s.compareTo(low) < 0)) {
    // // length in range; not starts with 0; not same len as low but smaller
    // // System.out.println(s);
    // res[0]++;
    // }
    // if (s.length() + 2 > high.length())
    // // outbound
    // return;
    // helper(low, high, "0" + s + "0", res);
    // helper(low, high, "1" + s + "1", res);
    // helper(low, high, "8" + s + "8", res);
    // helper(low, high, "6" + s + "9", res);
    // helper(low, high, "9" + s + "6", res);
    // }

    // DFS
    private static final char[][] pairs = { { '0', '0' }, { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };

    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        for (int len = low.length(); len < high.length(); len++) {
            char[] c = new char[len];
            dfs(low, high, c, 0, len - 1, res);
        }
        return res;
    }

    private void dfs(String low, String high, char[] c, int left, int right, int res) {
        if (left > right) {
            // finished strobogrammatic number; check if is between range
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0)
                    || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            res++;
            return;
        }
        // fill the char array with pairs
        for (char[] p : pairs) {
            if (left == right && p[0] != p[1])
                continue;
            c[left] = p[0];
            c[right] = p[1];
            if (c.length > 1 && c[0] == '0')
                continue;
            dfs(low, high, c, left + 1, right - 1, res);
        }
    }
}
// @lc code=end
