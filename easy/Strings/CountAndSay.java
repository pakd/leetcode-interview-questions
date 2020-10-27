class Solution {
    public String countAndSay(int n) {
        String prev = "1";
        for(int i=2; i<=n; i++) {
            prev = next(prev);
        }
        return prev;
    }
    
    public String next(String str) {
        StringBuilder sb = new StringBuilder();
        
        char fixed = str.charAt(0);
        int count = 1;
        int n = str.length();
        
        for(int i=1; i<n; i++) {
            if(str.charAt(i) == fixed) {
                count++;
            } else {
                sb.append(count).append(fixed);
                count = 1;
                fixed = str.charAt(i);
            }
        }
        sb.append(count).append(fixed);

        return sb.toString();
    }
}