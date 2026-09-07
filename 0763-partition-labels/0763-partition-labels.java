import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Record the last occurrence index of each character
        int[] lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Use two pointers to find the partition boundaries
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Expand the current partition window to include the last occurrence of the current character
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            
            // If the current index matches the furthest required index, we found a complete partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1; // Move the start pointer to the beginning of the next partition
            }
        }
        
        return result;
    }
}
