/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node() {}

    Node(int _val, Node* _next, Node* _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (!head)
            return NULL;
        Node *res, *old = head->next, *copy;
        res = new Node(head->val, head->next, head->random);
        head->next = res;
        while (old) {   // A-B-C => A-A'-B-B'-C-C'
            copy = new Node(old->val, old->next, old->random);
            old->next = copy;
            old = copy->next;
        }
        copy = res;
        old = head;
        while (copy) {
            if (copy->random) { // assign randoms
                copy->random = copy->random->next;
            }
            if (copy->next) {
                copy = copy->next->next;
            }
            else break;
        }
        copy = res;
        while (copy && old) {   // assign next for old and copy ones
            old->next = copy->next;
            old = old->next;
            if (old) {
                copy->next = old->next;
                copy = copy->next;
            }
        }
        return res;
    }
};