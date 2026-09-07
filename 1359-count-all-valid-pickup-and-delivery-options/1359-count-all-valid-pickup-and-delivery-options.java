class Solution {
    public int countOrders(int n) {
        final int MOD = 1_000_000_007;
        long result = 1;

        // For each order i from 2 to n, multiply by the number of valid ways
        // to insert the i-th pickup and delivery into the existing sequence.
        for (int i = 2; i <= n; i++) {
            long ways = i * (2L * i - 1);
            result = (result * ways) % MOD;
        }

        return (int) result;
    }
}
