class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int val = 0;
        int multiplier = 1;
        for(int i=n-1; i>=0; i--) {
            val += (arr[i] - 'A' + 1)* multiplier;
            multiplier*=26;
        }
        
        return val;
    }
}