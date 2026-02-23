/*
 * LeetCode 1461. Check If a String Contains All Binary Codes of Size K
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a binary string s and an integer k,
 *   return true if every binary code of length k is a substring of s.
 * - Otherwise, return false.
 *
 * Approach / Algorithm:
 * - There are 2^k possible binary codes of length k.
 * - Use a sliding window of size k across the string.
 * - Maintain a rolling bitmask to represent current k-length substring.
 * - Track seen codes using a boolean array.
 * - Reduce the count of remaining unseen codes.
 * - If all codes are seen, return true early.
 *
 * Time Complexity: O(n)
 *   - We traverse the string once.
 *
 * Space Complexity: O(2^k)
 *   - Boolean array to track seen binary codes.
 *
 * Important Details:
 * - Use bitmasking to efficiently represent substrings.
 * - Use (1 << k) - 1 to maintain only last k bits.
 */

class Solution {
    public boolean hasAllCodes(String s, int k) {

        int need = 1 << k;              // total possible codes
        boolean[] seen = new boolean[need];

        int mask = 0;
        int allOnes = need - 1;

        for (int i = 0; i < s.length(); i++) {

            mask = ((mask << 1) & allOnes) | (s.charAt(i) - '0');

            if (i >= k - 1) {
                if (!seen[mask]) {
                    seen[mask] = true;
                    need--;

                    if (need == 0)
                        return true;
                }
            }
        }

        return false;
    }
}
