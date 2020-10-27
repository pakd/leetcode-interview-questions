class Solution {
    public boolean isPowerOfThree(int n) {
        double val = Math.log10(n)/Math.log10(3);
        return (val%1 ==0)? true:false;
    }
}