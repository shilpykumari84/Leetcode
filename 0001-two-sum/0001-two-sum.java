import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store numbers and their corresponding indices
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists in the map, we found the pair
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
            
            // Otherwise, store the current number and its index
            numToIndex.put(nums[i], i);
        }
        
        // Return an empty array or throw an exception if no solution is found
        throw new IllegalArgumentException("No two sum solution found");
    }
}

