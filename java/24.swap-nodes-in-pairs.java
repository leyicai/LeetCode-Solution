/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    // iterative
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head, next = head.next;
        while (curr != null && curr.next != null) {
            next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
}
// @lc code=end
