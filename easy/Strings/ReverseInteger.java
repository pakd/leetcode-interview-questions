class Solution {
    public int reverse(int x) {
        
        int sign = (x<0)? -1: 1;
        long result = 0;
        long num = (long)Math.abs(x);
        
        while(num > 0) {
            result = result*10 + num%10;
            num = num/10;
        }
        
        // if not within range
        if(result > Integer.MAX_VALUE) return 0;
        
        return sign*(int)result;  
    }
}