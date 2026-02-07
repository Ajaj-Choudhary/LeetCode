/*
 * LeetCode 1653. Minimum Deletions to Make String Balanced
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given a string s consisting only of characters 'a' and 'b'.
 * - A string is considered balanced if there is no pair of indices (i, j)
 *   such that i < j, s[i] == 'b', and s[j] == 'a'.
 * - You may delete any number of characters from s.
 * - Return the minimum number of deletions needed to make the string balanced.
 *
 * Approach / Algorithm:
 * - Traverse the string from left to right.
 * - Maintain:
 *   - countB: number of 'b' characters seen so far.
 *   - deletions: minimum deletions needed up to the current position.
 * - For each character:
 *   - If it is 'b', increment countB.
 *   - If it is 'a':
 *     - Either delete this 'a' (deletions + 1),
 *     - Or delete all previous 'b's (countB).
 *     - Take the minimum of these two choices.
 * - Return the final deletions count.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles strings with all 'a's or all 'b's.
 * - Greedy approach ensures minimum deletions.
 * - Works in a single pass.
 */

class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else {
                deletions = Math.min(deletions + 1, countB);
            }
        }
        return deletions;
    }
}

