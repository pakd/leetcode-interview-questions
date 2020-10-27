public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int ans = 0;
        int power = 31;
        int mask = 1;
        
        for(int i=0; i<32; i++) {
            int temp = mask << i;
            
            if((n&temp) != 0) {
                ans += (1 << power);
            }
            power--;
        }
        
        return ans;
    }
}