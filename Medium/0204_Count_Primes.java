/*
 * LeetCode 204. Count Primes
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an integer n, return the number of prime numbers
 *   that are strictly less than n.
 *
 * Approach / Algorithm:
 * - Use the Sieve of Eratosthenes algorithm.
 * - Create a boolean array isPrime of size n and initialize all values to true.
 * - Mark 0 and 1 as non-prime implicitly by starting checks from 2.
 * - Iterate from 2 up to sqrt(n):
 *   - If the current number is marked prime, mark all its multiples
 *     starting from i * i as non-prime.
 * - After marking, count how many numbers from 2 to n - 1
 *   are still marked as prime.
 *
 * Time Complexity: O(n log log n)
 *   - Efficient prime counting using the sieve method.
 *
 * Space Complexity: O(n)
 *   - Uses a boolean array of size n.
 *
 * Important Details / Edge Cases:
 * - Returns 0 when n <= 2, since there are no primes less than 2.
 * - Starts marking multiples from i * i to avoid redundant work.
 * - Works efficiently for large values of n.
 */

class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        int count = 0;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }

        return count;
    }
}

