class Solution {
    public double myPow(double x, int n) {
        if(x == 1 || x == 0) {
            return x;
        }
        if(n < 0) {
            return myPowUtil(1/x, Math.abs(n));
        }
        return myPowUtil(x, n);
    }
    
    public double myPowUtil(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double y = myPowUtil(x, n/2);
        if(n%2 == 0) {
            return y*y;
        } else {
            return x*y*y;
        }
    }
}