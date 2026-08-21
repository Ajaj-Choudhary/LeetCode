/*
 * LeetCode 3116. Kth Smallest Amount With Single Denomination Combination
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - You are given an integer array coins representing coins of different denominations and an integer k.
 * - You have an infinite number of coins of each denomination, but you cannot combine coins of different denominations.
 * - Return the kth smallest amount that can be made using these coins.
 *
 * Constraints:
 *
 * - 1 <= coins.length <= 15
 * - 1 <= coins[i] <= 25
 * - 1 <= k <= 2 * 10^9
 * - coins contains pairwise distinct integers.
 *
 * Key Observation:
 *
 * - Use binary search to find the smallest amount for which at least k valid amounts can be made.
 * - Use inclusion-exclusion with LCM to count unique multiples of the given coin denominations without counting common multiples multiple times.
 *
 * Time Complexity: O(2^n * n * log(k * coins[0]))
 * Space Complexity: O(1)
 */

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) coins[0] * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (lcm <= x) {
                long multiples = x / lcm;

                if (bits % 2 == 1) {
                    count += multiples;
                } else {
                    count -= multiples;
                }
            }
        }

        return count;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}