/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// priority queue
class Solution {
public:
	ListNode* mergeKLists(vector<ListNode*>& lists) {
		auto cmp = [](ListNode * o1, ListNode * o2) {
			return o1->val > o2->val;
		};
		priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> q(cmp);
		for (ListNode* node : lists) {
			if (node != NULL) {
				q.push(node);
			}
		}
		if (q.size() == 0)
			return NULL;
		ListNode *head, *curr, *prev;
		head = q.top();
		q.pop();
		prev = head;
		if (prev->next) {
			q.push(prev->next);
		}
		while (q.size() != 0) {
			curr = q.top();
			q.pop();
			if (curr->next) {
				q.push(curr->next);
			}
			prev->next = curr;
			prev = curr;
		}
		return head;
	}
};
// recursively merge lists[0] and lists[1]
// easy to implement



// recursive
// + divide and conquer: merge left and right
class Solution {
public:
	ListNode* mergeKLists(vector<ListNode*>& lists) {
		if (lists.size() == 0)
			return NULL;
		return merge(lists, 0, lists.size() - 1);
	}
private:
	// merge lists[lo] to lists[hi]
	ListNode* merge(vector<ListNode*>& lists, int lo, int hi) {
		if (lo == hi) {
			return lists[lo];
		}
		int mid = (lo + hi) / 2;
		ListNode* left = merge(lists, lo, mid);
		ListNode* right = merge(lists, mid + 1, hi);

		return mergeTwoLists(left, right);
	}

	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		if (l1 == NULL)
			return l2;
		if (l2 == NULL)
			return l1;
		if (l1->val < l2->val) {
			l1->next = mergeTwoLists(l1->next, l2);
			return l1;
		}
		l2->next = mergeTwoLists(l1, l2->next);
		return l2;
	}
};