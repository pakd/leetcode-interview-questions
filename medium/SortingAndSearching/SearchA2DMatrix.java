class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // sanity checks
        int r = matrix.length;
        if(r == 0) return false;
        
        int c = matrix[0].length;
        if(c == 0) return false;
        
        int i = 0;
        int j = c-1;
        
        while(i < r && j >= 0) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}