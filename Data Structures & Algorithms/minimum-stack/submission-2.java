class MinStack {
    Deque<Integer> stack;
    Deque<Integer> stack2;
    public MinStack() {
        stack = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    public void push(int val) {
        stack.push(val);
        if (stack2.peek() != null){
            if (val < stack2.peek()){
                stack2.push(val);
            } else {
                stack2.push(stack2.peek());
            }
        } else {
            stack2.push(val);
        }
    }
    public void pop() {
        stack.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
