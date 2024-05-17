import java.util.*;

class MinStack {
    Stack<Integer> stk, min;

    public MinStack() {
        stk = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        this.stk.push(val);
        val = Math.min(val, this.min.isEmpty() ? val : this.min.peek());
        this.min.push(val);
    }

    public void pop() {
        this.stk.pop();
        this.min.pop();
    }

    public int top() {
        return this.stk.peek();
    }

    public int getMin() {
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
