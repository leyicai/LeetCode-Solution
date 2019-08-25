/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode low = head, high = head;
		while (n-- > 0) {
			high = high.next;
		}
		if (high == null) {
			// n = length of list
			return head.next;
		}
		while (high.next != null) {
			low = low.next;
			high = high.next;
		}
		low.next = low.next.next;
		return head;
	}
}

// Or: add a dummy node at the beginnig
// then change the while loop:
// while(high != null){}
// return dummy.next;