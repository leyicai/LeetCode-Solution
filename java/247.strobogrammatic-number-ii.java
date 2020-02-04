import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=247 lang=java
 *
 * [247] Strobogrammatic Number II
 */

// @lc code=start
// class Solution {
//     public List<String> findStrobogrammatic(int n) {
//         return helper(n, n);
//     }

//     private List<String> helper(int i, int n) {
//         if (i == 0) {
//             return new ArrayList<>(Arrays.asList(""));
//         }
//         if (i == 1) {
//             return new ArrayList<>(Arrays.asList("0", "1", "8"));
//         }
//         List<String> list = helper(i - 2, n);
//         List<String> res = new ArrayList<>();
//         for (String s : list) {
//             if (i != n) {
//                 res.add("0" + s + "0");
//             }
//             res.add("1" + s + "1");
//             res.add("8" + s + "8");
//             res.add("6" + s + "9");
//             res.add("9" + s + "6");
//         }
//         return res;
//     }
// }

// iterative
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2)
            return res;
        List<String> list;
        for (; n >= 2; n -= 2) {
            list = res;
            res = new ArrayList<>();
            for (String s : list) {
                if (n > 3) {
                    res.add("0" + s + "0");
                }
                res.add("1" + s + "1");
                res.add("8" + s + "8");
                res.add("6" + s + "9");
                res.add("9" + s + "6");
            }
        }

        return res;
    }
}
// @lc code=end
