/*
 * LeetCode 3871. Count Commas in Range II
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an integer n, return the total number of commas used when writing
 *   all integers from 1 to n in standard number formatting.
 * - A comma is inserted after every three digits from the right.
 * - Numbers with fewer than 4 digits contain no commas.
 *
 * Constraints:
 *
 * - 1 <= n <= 10^15
 *
 * Key Observation:
 *
 * - Every number from 1000 onward contains one comma.
 * - Every number from 1,000,000 onward contains an additional comma.
 * - Therefore, for every power of 1000, count how many numbers from that
 *   value through n contribute that comma.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public long countCommas(long n) {
        long result = 0;
        long start = 1000;

        while (start <= n) {
            result += (n - start + 1);
            start *= 1000;
        }

        return result;
    }
}