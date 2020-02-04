/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(count.entrySet());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll().getKey());
        }
        return res;
    }

    // bucket sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        LinkedList<Integer>[] buckets = new LinkedList[nums.length + 1];
        for (Integer num : count.keySet()) {
            Integer frequency = count.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new LinkedList<Integer>();
            }
            buckets[frequency].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            while (buckets[i] != null && !buckets[i].isEmpty() && res.size() < k) {
                res.add(buckets[i].poll());
            }
        }
        return res;
    }
}
// @lc code=end
