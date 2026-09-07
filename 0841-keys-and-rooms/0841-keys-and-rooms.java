import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        
        
        dfs(rooms, 0, visited);
        
        
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        
        visited[currentRoom] = true;
        
        
        for (int key : rooms.get(currentRoom)) {
            
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
}
