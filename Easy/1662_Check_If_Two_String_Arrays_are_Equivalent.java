/*
 * LeetCode 1662. Check If Two String Arrays are Equivalent
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given two string arrays word1 and word2, return true if both arrays
 *   represent the same string, otherwise return false.
 * - A string is represented by an array if its elements concatenated in order
 *   form the string.
 *
 * Constraints:
 *
 * - 1 <= word1.length, word2.length <= 10^3
 * - 1 <= word1[i].length, word2[i].length <= 10^3
 * - 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 *
 * Key Observation:
 *
 * - Concatenate all strings from word1 and word2 separately.
 * - Compare the two resulting strings to determine whether they represent
 *   the same string.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }
}