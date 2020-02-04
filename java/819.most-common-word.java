import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
        // System.out.println(Arrays.toString(words));
        Map<String, Integer> count = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
// @lc code=end
