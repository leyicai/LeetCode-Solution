import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    // public String[] reorderLogFiles(String[] logs) {
    // Comparator<String> logComp = new Comparator<String>() {
    // @Override
    // public int compare(String log1, String log2) {
    // String[] split1 = log1.split(" ", 2);
    // String[] split2 = log2.split(" ", 2);
    // boolean isLet1 = Character.isAlphabetic(split1[1].charAt(0));
    // boolean isLet2 = Character.isAlphabetic(split2[1].charAt(0));
    // if (isLet1 && isLet2) {
    // // two letter-log
    // int cmp = split1[1].compareTo(split2[1]);
    // // if two logs(without identifier) are same
    // // ordered by the identifier
    // return cmp == 0 ? split1[0].compareTo(split2[0]) : cmp;
    // }
    // // if (isLet1) {
    // // // log1 is letter-log, log2 is digit-log
    // // return -1;
    // // } else if (isLet2) {
    // // // log2 is letter-log, log1 is digit-log
    // // return 1;
    // // } else {
    // // // two digit-logs
    // // return 0;
    // // }
    // return isLet1 ? -1 : (isLet2 ? 1 : 0);
    // }
    // };
    // Arrays.sort(logs, logComp);
    // return logs;
    // }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isLet1 = Character.isAlphabetic(split1[1].charAt(0));
            boolean isLet2 = Character.isAlphabetic(split2[1].charAt(0));
            if (isLet1 && isLet2) {
                // two letter-log
                int cmp = split1[1].compareTo(split2[1]);
                // if two logs(without identifier) are same
                // ordered by the identifier
                return cmp == 0 ? split1[0].compareTo(split2[0]) : cmp;
            }
            return isLet1 ? -1 : (isLet2 ? 1 : 0);
        });
        return logs;
    }
}
// @lc code=end
