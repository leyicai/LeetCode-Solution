import java.util.HashSet;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    // hashset
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
        }
        return null;
    }

    // O(1) space with two pointers
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode intersect = findIntersect(head);
        if (intersect == null)
            return null;
        while (head != intersect) {
            head = head.next;
            intersect = intersect.next;
        }
        return head;
    }

    private ListNode findIntersect(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        while (head.next != null && fast.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
            if (head == fast) {
                return fast;
            }
        }
        return null;
    }
}
// @lc code=end
