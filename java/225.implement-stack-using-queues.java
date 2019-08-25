import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */
class MyStack {
    Queue<Integer> stack;

    /** Initialize your data structure here. */
    public MyStack() {
        this.stack = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
        for (int i = 0; i < stack.size() - 1; i++) {
            stack.add(stack.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
