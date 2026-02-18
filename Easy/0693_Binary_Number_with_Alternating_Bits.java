/*
 * LeetCode 693. Binary Number with Alternating Bits
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a positive integer n, check whether it has alternating bits.
 * - Alternating bits means no two adjacent bits are the same.
 *
 * Approach / Algorithm:
 * - XOR the number with itself right-shifted by 1.
 * - If bits are alternating, the result will be all 1s.
 * - A number consisting of all 1s has the property:
 *      x & (x + 1) == 0
 * - If this condition holds, the bits were alternating.
 *
 * Time Complexity: O(1)
 * - Constant time operations.
 *
 * Space Complexity: O(1)
 * - No extra space used.
 */

class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}

