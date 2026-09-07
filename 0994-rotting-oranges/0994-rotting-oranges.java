import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Initialize the queue with all initially rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If there are no fresh oranges, 0 minutes are needed
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        // Direction arrays for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Multi-source BFS
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            minutes++; // Increment time for the current level of infection
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    
                    // Check if the neighboring cell is valid and holds a fresh orange
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2; // Infect the orange
                        freshOranges--; // Reduce the remaining fresh orange count
                        queue.offer(new int[]{nextRow, nextCol}); // Add new rotten orange to the queue
                    }
                }
            }
        }
        
        // Step 3: Return result based on remaining fresh oranges
        return freshOranges == 0 ? minutes : -1;
    }
}