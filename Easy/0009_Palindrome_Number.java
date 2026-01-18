/* LeetCode 9. Palindrome Number
 * Difficulty: Easy
 *
 * Approach:
 * - Negative numbers are not palindromes.
 * - Reverse the number digit by digit.
 * - Compare the reversed number with the original.
 *
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int reverse = 0;
        int n = x;

        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }

        return x == reverse;
    }
}
