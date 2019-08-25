/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* reverseList(ListNode* head) {
		ListNode* rev_head = head;
		if (head == NULL) return rev_head;
		if (head->next == NULL) return rev_head;
		head = head->next;
		rev_head->next = NULL;
		while (head != NULL) {
			ListNode* temp = head->next;
			head->next = rev_head;
			rev_head = head;
			head = temp;
		}
		return rev_head;
	}
};


//recursive
//
class Solution {
public:
	ListNode* reverseList(ListNode* head) {
		ListNode* rev_head = head;
		if (head == NULL) return rev_head;
		if (head->next == NULL) return rev_head;
		head = head->next;
		rev_head->next = NULL;
		reverseList_recursion(head, rev_head);
		return rev_head;
	}
private:
	void reverseList_recursion(ListNode* &head, ListNode* &rev_head) {
		if (head == NULL) {
			return;
		}
		ListNode*p = head->next;
		head->next = rev_head;
		rev_head = head;
		reverseList_recursion(p, rev_head);
	}
};

///////////////
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* pre = NULL;
        while (head) {
            ListNode* next = head -> next;
            head -> next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
};
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head || !(head -> next)) {
            return head;
        }
        ListNode* node = reverseList(head -> next);
        head -> next -> next = head;
        head -> next = NULL;
        return node;
    }
};