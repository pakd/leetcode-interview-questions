class Solution {
    
    public boolean isSafe(char[][] grid, int i, int j, int r, int c) {
        if( 0 <= i && i < r && 0 <= j && j < c && grid[i][j] == '1') {
            return true;
        }
        return false;
    }
    
    public int numIslands(char[][] grid) {
        
        int r = grid.length;
        if(r == 0) return 0;
        
        int c = grid[0].length;

        int count = 0;
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, r, c);
                }
            }
        }

        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, int r, int c) {
        if(!isSafe(grid, i, j, r, c)) return;
        
        grid[i][j] = '0';
        
        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], r, c);
        }

    }
}