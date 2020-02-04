import java.util.HashMap;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node res, copy, old = head.next;
        res = new Node(head.val, head.next, head.random);
        head.next = res;
        while (old != null) {
            // copy every node in the old list
            // A-B-C -> A-A'-B-B'-C-C'
            // random points to old list
            copy = new Node(old.val, old.next, old.random);
            old.next = copy;
            old = copy.next; // tht orin next of old is now copy.next
        }
        copy = res;
        while (copy != null) {
            // point random of copy list to copy nodes
            if (copy.random != null) {
                copy.random = copy.random.next;
            }
            // move to next copy node
            if (copy.next != null) {
                copy = copy.next.next;
            } else {
                break;
            }
        }
        copy = res;
        old = head;
        while (old && copy) {
            // point next of two list to its own nodes
            old.next = copy.next;
            old = old.next;
            if (old != null) {
                copy.next = old.next;
                copy = copy.next;
            }
        }
        return res;
    }

    // hashmap
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node old = head, copy;
        while (old != null) {
            map.put(old, new Node(old.val, old.next, old.random));
            old = old.next;
        }
        old = head;
        while (old != null) {
            copy = map.get(old);
            copy.random = map.get(copy.random);
            copy.next = map.get(copy.next);
            old = old.next;
        }
        return map.get(head);
    }
}
// @lc code=end
