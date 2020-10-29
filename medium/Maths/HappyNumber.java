class Solution {
    public boolean isHappy(int n) {
        int slow = nextSequence(n);
        int fast = slow;
        do {
            slow = nextSequence(slow);
            fast = nextSequence(nextSequence(fast));
            if(slow == 1) {
                return true;
            }
        } while( slow != fast);
        return false;    
    }
    
    public int nextSequence(int n) {
        int result = 0;
        while(n > 0) {
            int x = n%10;
            result += x*x;
            n = n/10;
        }
        
        return result;
    }
}