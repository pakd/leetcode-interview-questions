class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        for(int i=5; i<=n; i=i+5) {
            int x = i;
            int localCount = 0;
            while(x%5 == 0 ) {
                localCount++;
                x = x/5;
            }
            zeroCount += localCount;
        }
        return zeroCount;
    }
}