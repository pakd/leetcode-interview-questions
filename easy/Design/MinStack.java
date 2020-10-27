class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        // when stacks are empty
        if(stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
            return;
        }
        
        stack.push(x);
        int minStackTop = minStack.peek();
        
        if(x <= minStackTop) minStack.push(x);
    }
    
    public void pop() {
        int stackTop = stack.peek();
        int minStackTop = minStack.peek();
        if(stackTop == minStackTop) {
            stack.pop();
            minStack.pop();
        } else {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}