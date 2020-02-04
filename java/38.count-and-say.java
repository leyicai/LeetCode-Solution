/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        StringBuilder temp;
        int count;
        n--;
        while (n > 0) {
            count = 1;
            temp = res;
            res = new StringBuilder();
            int i;
            for (i = 0; i < temp.length() - 1; i++) {
                if (temp.charAt(i) == temp.charAt(i + 1)) {
                    count++;
                } else {
                    res.append(count).append(temp.charAt(i));
                    // System.out.println(res.toString());
                    count = 1;
                }
            }
            res.append(count).append(temp.charAt(i));
            n--;
        }
        return res.toString();
    }
}
