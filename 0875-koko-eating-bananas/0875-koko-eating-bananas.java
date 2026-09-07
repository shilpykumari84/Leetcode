class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Minimum possible eating speed is 1 banana per hour
        int left = 1; 
        
        // Maximum required speed is the size of the largest pile
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        // Binary search for the minimum valid speed
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                // If mid speed works, try to find a smaller valid speed
                right = mid;
            } else {
                // If mid speed is too slow, we must increase the speed
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canEatAll(int[] piles, int h, int speed) {
        long totalHours = 0; // Use long to prevent integer overflow
        
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / speed)
            totalHours += (pile + speed - 1) / speed;
            
            // Optimization: If hours already exceed h, stop checking this speed
            if (totalHours > h) {
                return false;
            }
        }
        
        return totalHours <= h;
    }
}
