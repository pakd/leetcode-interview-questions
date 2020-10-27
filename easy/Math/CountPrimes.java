class Solution {
    public int countPrimes(int n) {
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for(int i=2; i<Math.sqrt(n); i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<n; j=j+i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for(int i=2; i<n; i++) {
            if(isPrime[i]) count++;
        }
        
        return count;
    }
}