/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */
// class MedianFinder {

//     /** initialize your data structure here. */
//     public MedianFinder() {

//     }

//     public void addNum(int num) {
//         large.add(num);
//         small.add(-large.poll());
//         if (small.size() > large.size()) {
//             large.add(-small.poll());
//         }
//     }

//     public double findMedian() {
//         return small.size() < large.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
//     }

//     private Queue<Integer> small = new PriorityQueue();
//     private Queue<Integer> large = new PriorityQueue();

// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
class MedianFinder {
    class TreeNode {
        int val;
        TreeNode parent, left, right;

        TreeNode(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
            left = null;
            right = null;
        }

        void add(int num) {
            if (num >= val) {
                // add to right subtree
                if (right == null) {
                    right = new TreeNode(num, this);
                } else {
                    right.add(num);
                }
            } else {
                // add to left subtree
                if (left == null) {
                    left = new TreeNode(num, this);
                } else {
                    left.add(num);
                }
            }
        }

        TreeNode nextNode() {
            TreeNode next;
            if (right != null) {
                // next is the leftmost of right subtree
                next = right;
                while (next.left != null) {
                    next = next.left;
                }
            } else {
                next = this;
                while (next.parent.right == next) {
                    // this is the only right child of its parent
                    // go up left until next is a left child
                    next = next.parent;
                }
                next = next.parent;
                // this is the rightmost of next's left subtree
            }
            return next;
        }

        TreeNode prevNode() {
            TreeNode prev;
            if (left != null) {
                prev = left;
                while (prev.right != null) {
                    prev = prev.right;
                }
            } else {
                prev = this;
                while (prev.parent.left == prev) {
                    prev = prev.parent;
                }
                prev = prev.parent;
            }
            return prev;
        }
    }

    private int size;
    TreeNode root, curr; // curr is median when size is odd, or middle left when size is even

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (root == null) {
            root = new TreeNode(num, null);
            curr = root;
            size = 1;
        } else {
            root.add(num);
            size++;
            // update curr
            if (size % 2 == 1) {
                // size is odd
                if (curr.val <= num) {
                    curr = curr.nextNode();
                }
                // else curr stay same
            } else {
                // size is even
                if (curr.val > num) {
                    curr = curr.prevNode();
                }
            }
        }
    }

    public double findMedian() {
        if (size % 2 == 1) {
            return curr.val;
        } else {
            return (curr.val + curr.nextNode().val) / 2.0;
        }
    }
}
