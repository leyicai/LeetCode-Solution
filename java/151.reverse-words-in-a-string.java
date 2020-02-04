/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        // s.trim(): remove leading and trailing spaces
        String[] arr = s.trim().split("\\s+");
        int i = 0, j = arr.length - 1;
        while (i < j) {
            String tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        return String.join(" ", arr);
    }

}

// Without trim and split
class Solution {
    public String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            ;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ')
                j--;
            sb.append(" ");
            sb.append(s.substring(j + 1, i + 1));
            i = j - 1;
        }
        if (sb.length() > 0)
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
