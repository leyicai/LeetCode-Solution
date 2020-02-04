/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = head, next;
        if (head == null || head.next == null) {
            return reverse;
        }
        head = head.next;
        reverse.next = null;
        while(head!=null) {
            next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
}
// @lc code=end

