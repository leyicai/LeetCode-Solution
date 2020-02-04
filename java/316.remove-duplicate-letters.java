import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0)
            return "";
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int pos = 0; // the pos of smallest s[i]
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--count[s.charAt(i) - 'a'] == 0)
                // unique s[i]
                break;
        }
        String suffix = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
        return s.charAt(pos) + removeDuplicateLetters(suffix);
    }
}

// Stack
class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0)
            return "";
        Deque<Character> stack = new LinkedList<>();
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            cnt[c - 'a']--;
            if (visited[c - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.poll();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.poll());
        }
        return res.reverse().toString();
    }
}
