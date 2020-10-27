class Solution {
    
    int[] nums;
    int[] copy;
    Random rand = new Random();

    int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public Solution(int[] nums) {
        this.nums = nums;
        
        copy = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            copy[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copy;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int max = nums.length;
        for(int i=0; i<nums.length; i++) {
            int j = randRange(i, max);
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        return nums;
    }
}