class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowContainsZero = false;
        boolean isFirstColContainsZero = false;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        
        // first row
        for(int i=0; i<c; i++) {
            if(matrix[0][i] == 0) {
                isFirstRowContainsZero = true;
                break;
            }
        }
        
        // first col
        for(int i=0; i<r; i++) {
            if(matrix[i][0] == 0) {
                isFirstColContainsZero = true;
                break;
            }
        }
        
        // using first col and row
        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(isFirstRowContainsZero) {
            for(int i=0; i<c; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if(isFirstColContainsZero) {
            for(int i=0; i<r; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}