class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Map<Integer, Integer> dp = new HashMap<>();

        // Initially, sum 0 has 1 way
        dp.put(0, 1);

        for (int num : nums) {

            Map<Integer, Integer> next = new HashMap<>();

            for (int sum : dp.keySet()) {

                // Add +
                int plus = sum + num;
                next.put(plus,
                    next.getOrDefault(plus, 0) + dp.get(sum));

                // Add -
                int minus = sum - num;
                next.put(minus,
                    next.getOrDefault(minus, 0) + dp.get(sum));
            }

            dp = next;
        }

        return dp.getOrDefault(target, 0);
    }
}
