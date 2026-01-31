/*
 * LeetCode 744. Find Smallest Letter Greater Than Target
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given a sorted array of characters letters containing only lowercase letters
 *   and a target character target.
 * - Return the smallest character in the array that is strictly greater than target.
 * - The array is considered circular, meaning if no character is greater than target,
 *   return the first character in the array.
 *
 * Approach / Algorithm:
 * - Use Binary Search since the array is sorted.
 * - Initialize two pointers, left and right, and a variable result set to letters[0]
 *   to handle the circular condition.
 * - While left <= right:
 *   - Find the middle index.
 *   - If letters[mid] is greater than target:
 *     - Update result with letters[mid].
 *     - Search the left half to find a smaller valid character.
 *   - Otherwise, search the right half.
 * - Return result after the loop completes.
 *
 * Time Complexity: O(log n)
 *   - n = number of characters in the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles the circular condition when target is greater than or equal to all characters.
 * - Assumes the input array is non-empty.
 * - Works correctly when multiple characters satisfy the condition.
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        char result = letters[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                result = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}

