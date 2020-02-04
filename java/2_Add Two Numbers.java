/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = l1;
        while (l1 != null) {
            l1.val += carry + (l2 == null ? 0 : l2.val);
            carry = l1.val / 10;
            l1.val %= 10;
            if (l1.next == null && l2 != null) {
                // if l1.next is null and l2 not null, link l2 to l1 and set l2 to null
                // the loop then go through l1 with carry
                l1.next = l2.next;
                l2 = null;
            }
            if (l1.next == null && carry != 0) {
                // add the extra carry
                l1.next = new ListNode(1);
                carry = 0;
            }
            l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return root;
    }
}

// recursion
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        ListNode head = new ListNode(val % 10);
        head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        if (val >= 10)
            head.next = addTwoNumbers(head.next, new ListNode(1));
        return head;
    }
}

// with a new list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
}