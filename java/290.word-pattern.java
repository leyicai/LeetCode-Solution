import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length)
            return false;
        System.out.println(Arrays.toString(strArr));
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strArr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strArr[i])) {
                    return false;
                }
                map.put(c, strArr[i]);
            }
        }
        return true;
    }
}

// map with index
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<String, Integer> index = new HashMap<>();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i) + "", i) != index.put(words[i] + " ", i))
                return false;
        return true;
    }
}