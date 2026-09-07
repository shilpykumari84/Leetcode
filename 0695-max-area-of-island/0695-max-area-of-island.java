class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        // Traverse every cell in the grid
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // If we find land (1), it's a potential maximum island
                if (grid[r][c] == 1) {
                    int currentArea = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

return maxArea;
    }
private int dfs(int[][] grid, int r, int c) {
        // Base case: Check boundary conditions and if the cell is water (0)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        // Sink the island (mark as visited by changing 1 to 0) to prevent infinite loops
        grid[r][c] = 0;
        
        // Count this cell (1) and recursively search all 4 adjacent directions
        return 1 + dfs(grid, r + 1, c) // Down
                 + dfs(grid, r - 1, c) // Up
                 + dfs(grid, r, c + 1) // Right
                 + dfs(grid, r, c - 1); // Left
}
        }
