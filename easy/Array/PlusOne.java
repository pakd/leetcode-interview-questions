class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int carry = 0;
        
        for(int i=n-1; i>=0; i--) {
            int term = digits[i] + 1;
            carry = term/10;
            term = term%10;
            digits[i] = term;
            
            if(carry == 0) {
                return digits;
            }
        }
        
        if(carry != 0) {
            int[] ret = new int[n+1];
            ret[0] = carry;
            
            for(int i=0; i<n; i++) {
                ret[i+1] = digits[i]; 
            }
            return ret;
        }
        
        return digits;
    }
}