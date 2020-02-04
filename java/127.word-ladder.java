import java.util.*;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (endWord.equals(curr))
                    return res;
                char[] chs = curr.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[j] = c;
                        if (wordSet.contains(String.valueOf(chs))) {
                            queue.offer(String.valueOf(chs));
                            wordSet.remove(String.valueOf(chs));
                        }
                    }
                    chs[j] = old;
                }
            }
        }
        return 0;
    }

    // two-end BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), wordSet = new HashSet<>(wordList);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int res = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            res++;
            if (beginSet.size() > endSet.size()) {
                // swap. always explore the smaller one
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmpSet = new HashSet<>();
            for (String curr : beginSet) {
                char[] chs = curr.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        // substitute one letter in current word
                        chs[i] = c;
                        String word = String.valueOf(chs);
                        if (endSet.contains(word)) // solution found
                            return res + 1;
                        if (wordSet.contains(word)) {
                            tmpSet.add(word); // a valid ladder in this level
                            wordSet.remove(word); // remove visited word
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = tmpSet; // tmpSet(the new level of words) becomes the new beginSet
        }
        return 0;
    }

}
// @lc code=end
