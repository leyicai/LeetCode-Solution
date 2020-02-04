/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        // now slow is the middle point
        // reverse the second half
        slow = reverseList(slow);
        while (fast != null && slow != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode reverse = null, next;
        while (head != null) {
            next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }
}
// @lc code=end
