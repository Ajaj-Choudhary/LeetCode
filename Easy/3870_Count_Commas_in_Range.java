/*
 * LeetCode 3870. Count Commas in Range
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an integer n, count the total number of commas used when writing
 *   all integers from 1 to n in standard number formatting.
 * - A comma is inserted after every three digits from the right.
 * - Numbers with fewer than 4 digits contain no commas.
 *
 * Constraints:
 *
 * - 1 <= n <= 10^5
 *
 * Key Observation:
 *
 * - Numbers from 1 to 999 contain no commas.
 * - Since n <= 10^5, every number from 1000 to n contains exactly one comma.
 * - Therefore, the total number of commas is the count of numbers from 1000
 *   to n, which is n - 999.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int countCommas(int n) {
        return Math.max(n - 999, 0);
    }
}