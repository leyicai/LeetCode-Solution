/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head -> next == null || head == null) {
			return head;
		}
		ListNode prev = head;
		ListNode curr  = head.next;
		while (curr != null) {
			if (prev.val == curr.val) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
}

// Recursive version
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head -> next == null || head == null) {
			return head;
		}
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}
}