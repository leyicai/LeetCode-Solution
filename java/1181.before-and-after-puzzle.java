import java.util.*;

/*
 * @lc app=leetcode id=1181 lang=java
 *
 * [1181] Before and After Puzzle
 */

// @lc code=start
class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> map = new HashMap<>(); // first word -> list of indices that the phrase staring with
                                                          // the word
        // Store first words and indices into map
        for (int i = 0; i < phrases.length; i++) {
            String first = getFirst(phrases[i]);
            if (!map.containsKey(first))
                map.put(first, new ArrayList<>());
            map.get(first).add(i);
        }
        // Match with last words
        Set<String> puzzleSet = new HashSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String last = getLast(phrases[i]);
            if (map.containsKey(last)) {
                // match found
                for (Integer j : map.get(last)) {
                    if (i != j)
                        puzzleSet.add(phrases[i] + phrases[j].substring(last.length()));
                }
            }
        }
        // Turn into list and sort
        List<String> res = new ArrayList<>(puzzleSet);
        Collections.sort(res);
        return res;
    }

    private String getFirst(String phrase) {
        String[] words = phrase.split(" ");
        return words[0];
    }

    private String getLast(String phrase) {
        String[] words = phrase.split(" ");
        return words[words.length - 1];
    }

    /////// Two maps with firstWords and lastWords
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        // word -> list of indices of strings start/ends with word
        Map<String, List<Integer>> firstWords = new HashMap<>(), lastWords = new HashMap<>();

        // Store first words and indices into map
        for (int i = 0; i < phrases.length; i++) {
            String[] words = phrases[i].split(" ");
            String first = words[0], last = words[words.length - 1];
            if (!firstWords.containsKey(first))
                firstWords.put(first, new ArrayList<>());
            firstWords.get(first).add(i);
            if (!lastWords.containsKey(last))
                lastWords.put(last, new ArrayList<>());
            lastWords.get(last).add(i);

        }
        // Match with last words
        TreeSet<String> puzzleSet = new TreeSet<>();
        for (String last : lastWords.keySet()) {
            if (firstWords.containsKey(last)) {
                // match found
                for (Integer i : lastWords.get(last)) {
                    for (Integer j : firstWords.get(last)) {
                        if (i != j)
                            puzzleSet.add(phrases[i] + phrases[j].substring(last.length()));
                    }
                }
            }
        }
        return new ArrayList<>(puzzleSet);
    }

}
// @lc code=end
