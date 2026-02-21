/*
 * LeetCode 762. Prime Number of Set Bits in Binary Representation
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given two integers left and right, return the count of numbers
 *   in the inclusive range [left, right] having a prime number of set bits.
 *
 * Approach / Algorithm:
 * - Iterate from left to right.
 * - For each number, count the set bits using Integer.bitCount().
 * - Check if the count is prime.
 * - If prime, increment the result counter.
 *
 * Time Complexity: O(n * log n)
 *   - n = right - left
 *   - bitCount takes O(log n)
 *
 * Space Complexity: O(1)
 *
 * Important Details:
 * - Maximum set bits for int (<= 10^6 range typical) is small (<= 20),
 *   so prime checking is fast.
 */

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i <= num / i; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }

        return true;
    }
}
