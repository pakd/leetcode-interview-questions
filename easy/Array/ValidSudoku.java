class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        int row = board.length; // 9
        int col = row;
        
        // validate rows
        for(int i=0; i<row; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<col; j++) {
                char temp = board[i][j];
                if(temp != '.') {
                    if(set.contains(temp)) {
                        return false;
                    } else {
                        set.add(temp);
                    }
                }
            }   
        }
        
        // validate columns
        for(int i=0; i<col; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<row; j++) {
                char temp = board[j][i];
                if(temp != '.') {
                    if(set.contains(temp)) {
                        return false;
                    } else {
                        set.add(temp);
                    }
                }
            }   
        }
        
        // validate 3*3 grid
        for(int i=0; i<row; i=i+3) {
            for(int j=0; j<col; j=j+3) {
                
                Set<Character> set = new HashSet<>();
                
                for(int k=i; k<i+3; k++) {
                    for(int l=j; l<j+3; l++) {
                        char temp = board[k][l];
                        if(temp != '.') {
                            if(set.contains(temp)) {
                                return false;
                            } else {
                                set.add(temp);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}