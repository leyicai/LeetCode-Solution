/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev, curr, next;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            // prev is the previous node of the reversed sublist
            prev = prev.next;
        }
        curr = prev.next;
        next = curr.next;
        for (int i = 0; i < n - m; i++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
}
// @lc code=end
