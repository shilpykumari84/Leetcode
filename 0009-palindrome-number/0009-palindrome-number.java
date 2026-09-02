class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases: 
        // 1. Negative numbers are not palindromes (e.g., -121 reads as 121-).
        // 2. Numbers ending in 0 are not palindromes, except for 0 itself (e.g., 10, 200).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Process digits until the reversed half is greater than or equal to the remaining half
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers (e.g., 1221): x will equal reversedHalf (12 == 12)
        // For odd-length numbers (e.g., 12321): x will equal reversedHalf / 10 (12 == 123 / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
