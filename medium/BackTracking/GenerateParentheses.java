class Solution {
    
    boolean isValidString(String str) {
        int count = 0;
        
        for(char c : str.toCharArray()) {
            switch(c) {
                case '(': 
                    count++;
                    break;
                case ')':
                    count--;
                    break;
            }
            
            if(count < 0) return false;
        }
        
        return (count == 0)? true: false;
    }
    
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        generateParenthesisUtil(ans, sb, 2*n);
        return ans;
    }
    
    public void generateParenthesisUtil(List<String> ans, StringBuilder curr, int size) {
        if(curr.length() == size) {
            if(isValidString(curr.toString()) && !ans.contains(curr.toString())) {
                ans.add(curr.toString());
            }
            return;
        }
        
        char arr[] = {'(', ')'};
        
        for(char c : arr) {
            // choose
            curr.append(c);
            
            // explore
            generateParenthesisUtil(ans, curr, size);
            
            // unchoose
            curr.setLength(curr.length()-1);
        }
    }
}