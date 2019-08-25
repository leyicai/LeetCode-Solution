class MinStack {

    /** initialize your data structure here. */
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            stack.addFirst(min);
            min = x;
        }
        stack.addFirst(x);
    }

    public void pop() {
        int x = stack.pollFirst();
        if (x == min) {
            min = stack.pollFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */