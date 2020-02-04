/*
 * @lc app=leetcode id=358 lang=java
 *
 * [358] Rearrange String k Distance Apart
 */

// @lc code=start
// class Solution {
//     public String rearrangeString(String s, int k) {
//         StringBuilder res = new StringBuilder();
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         // construct a max heap using self-defined comparator
//         // sort the map with descending order of value(frequency)
//         Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//         maxHeap.addAll(map.entrySet());
//         // System.out.println(maxHeap.toString());
//         Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
//         while (!maxHeap.isEmpty()) {
//             Map.Entry<Character, Integer> entry = maxHeap.poll();
//             res.append(entry.getKey());
//             entry.setValue(entry.getValue() - 1);
//             queue.add(entry);
//             if (queue.size() < k) {
//                 continue;
//             }
//             // queue is of length k, same char are k away from each other
//             Map.Entry<Character, Integer> next = queue.poll();
//             if (next.getValue() > 0) {
//                 // re-enter heap to be rearraged
//                 maxHeap.add(next);
//             }
//         }
//         System.out.println(res.toString());
//         return res.length() == s.length() ? res.toString() : "";
//     }
// }

// Greedy with two array
class Solution {
    public String rearrangeString(String s, int k) {
        int[] map = new int[26];
        int[] validPos = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int index = 0; index < s.length(); index++) {
            int offset = findCharOffset(index, map, validPos);
            if (offset == -1)
                return "";
            res.append((char) ('a' + offset));
            validPos[offset] = index + k;
            map[offset]--;
        }
        return res.toString();
    }

    // find the offset of character that with most count and is valid to put at
    // index
    public int findCharOffset(int index, int[] map, int[] validPos) {
        int maxCount = 0;
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (map[i] > maxCount && index >= validPos[i] && i > res) {
                res = i;
                maxCount = map[i];
            }
        }
        return res;
    }
}

// @lc code=end
