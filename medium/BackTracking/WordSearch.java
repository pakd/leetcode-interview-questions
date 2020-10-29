class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(word.length() == 0) return true;

        int r = board.length;
        int c = board[0].length;
        
        char firstChar = word.charAt(0);
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == firstChar && dfs(board, i, j , 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isSafe(char[][] board, int i, int j, char d) {
        int r = board.length;
        int c = board[0].length;
        
        if( 0 <= i && i < r && 0 <= j && j < c && board[i][j] == d) {
            return true;
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        
        if( count == word.length() ) return true;
        
        if(!isSafe(board, i, j, word.charAt(count))) return false;
        
        // to avoid duplications
        char temp = board[i][j];
        board[i][j] = '.';
        
        int[][] dirs = { {1, 0}, {0, 1}, { -1, 0}, {0 , -1} };
        
        boolean found = false;
        
        for(int[] dir : dirs) {
            found = found || dfs(board, i + dir[0], j + dir[1], count+1, word);
        }
        
        board[i][j] = temp;
        return found;
    }
    
}