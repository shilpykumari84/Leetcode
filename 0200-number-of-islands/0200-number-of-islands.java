class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Scan every cell in the 2D grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a cell with value '1' is found, it's a new island
                if (grid[i][j] == '1') {
                    islandCount++;
                    // Trigger DFS to mark the entire connected island as visited
                    dfs(grid, i, j);
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base cases: check for out-of-bounds or if the cell is water/already visited
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') {
            return;
        }
        
        // Mark the current land cell as visited by turning it to '0'
        grid[r][c] = '0';
        
        // Recursively visit all 4 adjacent neighbors (Up, Down, Left, Right)
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}
