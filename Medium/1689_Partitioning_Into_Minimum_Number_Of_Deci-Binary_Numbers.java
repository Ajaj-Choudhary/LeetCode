/*
 * LeetCode 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * Difficulty: Medium
 *
 * Problem Statement:
 * - A decimal number is called deci-binary if each digit is either 0 or 1.
 * - Given a string n representing a positive decimal integer,
 *   return the minimum number of positive deci-binary numbers needed
 *   so that they sum up to n.
 *
 * Key Observation:
 * - Each deci-binary number contributes at most 1 to each digit position.
 * - Therefore, the minimum number required equals
 *   the maximum digit present in n.
 *
 * Example:
 * n = "32"
 * max digit = 3 → answer = 3
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
            
            if (maxDigit == 9) {
                return 9; // Early exit (maximum possible digit)
            }
        }

        return maxDigit;
    }
}
