class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        
        int mask = 1;
        int count = 0;
        for(int i=0; i<32; i++) {
            int temp = xor&mask;
            if (temp != 0) count++;
            mask = mask << 1;
        }
        return count;
    }
}