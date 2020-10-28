class Solution {
    public int getSum(int a, int b) {
        
        // carries can be found easily by a&b << 1
        // terms in sum can be found easily by a^b
        // problem is converted into carries + xor
        // keep doing this until carry will tends to 0
        // a will be used for storing xor
        // b will be used for storing shifted carries
        
        while(b != 0) {
            int carry = a&b;
            int xor = a^b;
            a = xor;
            b = carry << 1;
        }
        
        return a;
    }
}