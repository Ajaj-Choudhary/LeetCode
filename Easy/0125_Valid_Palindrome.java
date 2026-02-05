/*
 * LeetCode 125. Valid Palindrome
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a string s, determine if it is a palindrome,
 *   considering only alphanumeric characters and ignoring cases.
 *
 * Approach / Algorithm:
 * - Use the two-pointer technique.
 * - Initialize two pointers:
 *   - left starting from the beginning of the string.
 *   - right starting from the end of the string.
 * - Move the left pointer forward until it points to an alphanumeric character.
 * - Move the right pointer backward until it points to an alphanumeric character.
 * - Compare the characters at left and right after converting them to lowercase.
 * - If they are not equal, return false.
 * - Move both pointers inward and continue until they cross.
 * - If all comparisons match, return true.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Ignores non-alphanumeric characters.
 * - Case-insensitive comparison.
 * - An empty string or string with only non-alphanumeric characters is considered a palindrome.
 */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

