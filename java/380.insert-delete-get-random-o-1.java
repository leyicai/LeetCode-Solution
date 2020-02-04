/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

    private Map<Integer, Integer> map; // val->idx
    private List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val); // insert to the end of list
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int idx = map.remove(val);
        int lastVal = list.get(list.size() - 1);
        list.set(idx, lastVal);
        list.remove(list.size() - 1);
        if (list.size() > idx)
            map.put(list.get(idx), idx);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
