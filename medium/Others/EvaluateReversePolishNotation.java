class Solution {
    Stack<Integer> st = new Stack<>();
    Set<String> set = new HashSet<>();
    
    public int evalRPN(String[] tokens) {
        int result = 0;
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        int n = tokens.length;
        int c = 0;
        for(int i=0; i<n; i++) {
            if(set.contains(tokens[i])) {
                int a = st.pop();
                int b = st.pop();
                
                switch(tokens[i]) {
                    case "+":
                        c = a + b; 
                        break;
                        
                    case "-":
                        c = b - a;
                        break;
                        
                    case "*":
                        c = b*a;
                        break;
                        
                    case "/":
                        c = b/a;
                        break;
                        
                    default:
                        break;
                }
                st.push(c);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}