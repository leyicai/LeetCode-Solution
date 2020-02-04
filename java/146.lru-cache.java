import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class ValueWithTimestamp {
        int value;
        int timestamp;

        ValueWithTimestamp(int value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
        public String toString() {
            return this.value + ":" + this.timestamp;
        }

    }

    private int capacity;
    private Map<Integer, ValueWithTimestamp> cache;
    private int timer;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.timer = 0;
    }

    public int get(int key) {
        // System.out.println(cache);
        if (cache.containsKey(key)) {\
            // update timestamp
            cache.get(key).timestamp = timer++;
            return cache.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        cache.put(key, new ValueWithTimestamp(value, timer++));
        if (cache.size() > capacity) {
            // evicts LRU
            int min = Integer.MAX_VALUE;
            int evict = key;
            for (Map.Entry<Integer, ValueWithTimestamp> entry : cache.entrySet()) {
                if (entry.getValue().timestamp < min) {
                    evict = entry.getKey();
                    min = entry.getValue().timestamp;
                }
            }
            cache.remove(evict);
        }
    }
}

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    // add node to tail
    private void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    // remove a node
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.key + "=" + node.value + "->");
            node = node.next;
        }
        System.out.println();
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            // printList();
            return -1;
        } else {
            // move node to end;
            removeNode(node);
            addNode(node);
            // printList();
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            addNode(node);
        } else {
            // move node to end
            removeNode(node);
            addNode(node);
        }
        node.key = key;
        node.value = value;
        cache.put(key, node);
        if (cache.size() > capacity) {
            // eviction needed
            Node evict = head.next;
            cache.remove(evict.key);
            removeNode(evict);
        }
        // printList();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
