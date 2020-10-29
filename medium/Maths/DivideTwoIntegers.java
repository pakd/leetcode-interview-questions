class Solution {
    public int divide(int dividend, int divisor) {
        
        long dividendLong = (long) dividend;
        long divisorLong = (long) divisor;
        
        // sanity checks
        if(dividendLong == 0 || divisorLong == 0) {
            return 0;
        }
        
        int sign = 1;
        if(divisorLong < 0 && dividendLong < 0) {
            sign = 1;
        } else if(divisorLong < 0 || dividendLong < 0) {
            sign = -1;
        }
        
        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);
        
        
        long ans = 0;
        long num = divisorLong;
        
        if(divisorLong == 1) {
            ans = dividendLong;
            if(ans > (int)Integer.MAX_VALUE) {
                return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
            } else {
                return sign*(int)ans;
            }
        }

        while(num <= dividendLong) {
            num += divisorLong;
            ans++;
        }
        
        if(ans > (int)Integer.MAX_VALUE) {
            return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return sign*(int)ans;
    }
}