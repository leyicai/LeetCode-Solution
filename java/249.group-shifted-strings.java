import java.util.*;

// [249] Group Shifted Strings
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strings) {
            StringBuilder key = new StringBuilder();
            int diff = 0;
            for (int i = 1; i < s.length(); i++) {
                diff = s.charAt(i) - s.charAt(i - 1);
                diff += diff < 0 ? 26 : 0;
                key.append('a' + diff);
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        }
        for (ArrayList<String> value : map.values()) {
            Collections.sort(value);
        }
        return new ArrayList<>(map.values());
    }
}