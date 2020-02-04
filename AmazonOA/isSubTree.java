class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int isSubTree(BinaryTreeNode s, BinaryTreeNode t) {
        // INSERT YOUR CODE HERE
        if (s == null) {
            return -1;
        }
        if (isSameTree(s, t)) {
            return 1;
        }
        if (isSubTree(s.left, t) == 1 || isSubTree(s.right, t) == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean isSameTree(BinaryTreeNode s, BinaryTreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (t.value == s.value) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
    // METHOD SIGNATURE ENDS
}