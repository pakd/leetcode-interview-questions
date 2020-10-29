class Solution {
    public int mySqrt(int x) {
        
       if(x < 2) {
            return x;
        }
        
        
        // O(X)
        // long i;
        // for(i=1; i*i <= x; i++) {}  
        // return (int)i-1;
        
        // Lets do in O(logX)

        long low = 1;
        long high = x/2;
        long xLong = x;
        
        int result = 0;
        
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            if(mid*mid <= xLong) {
                result = (int)mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return result;
    }
}