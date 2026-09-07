class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        // Iterate through every city
        for (int i = 0; i < n; i++) {
            // If the city hasn't been visited yet, it belongs to a new province
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++; // Increment the total province count
            }
        }

        return provinceCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int currentCity) {
        // Mark the current city as visited
        visited[currentCity] = true;

        // Check all potential neighboring cities
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            // If there is a direct connection and the neighbor hasn't been visited
            if (isConnected[currentCity][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}
