/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
// two pointers: fast and slow
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head;
        while (head.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
            if (head == fast) {
                return true;
            }
        }
        return false;

    }

    // 2. HashSet
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }
}
// @lc code=end
