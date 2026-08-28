/*
 * LeetCode 344. Reverse String
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Write a function that reverses a string.
 * - The input string is given as an array of characters s.
 * - Modify the input array in-place using O(1) extra memory.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 10^5
 * - s[i] is a printable ASCII character.
 *
 * Key Observation:
 *
 * - Use two pointers starting from both ends of the array.
 * - Swap the characters at the two pointers and move them toward the center until the entire array is reversed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}