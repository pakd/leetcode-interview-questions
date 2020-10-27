class Solution {
    
    boolean isMatching(char a, char b) {
        if((a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']')) return true;
        return false;
    }
    
    public boolean isValid(String s) {    
        Stack<Character> stack = new Stack<>();
    
        for(char x : s.toCharArray()) { 
            if(x == '{' || x == '[' || x == '(') {
                stack.push(x);
            } else {
                if(!stack.isEmpty() && isMatching(stack.peek(), x)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
            
        return (stack.isEmpty())? true : false;
    }
}