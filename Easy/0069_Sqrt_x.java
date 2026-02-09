/*
 * LeetCode 69. Sqrt(x)
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a non-negative integer x, return the square root of x
 *   rounded down to the nearest integer.
 * - The returned value must be non-negative.
 * - You must not use any built-in exponent function or operator.
 *
 * Approach / Algorithm:
 * - Use Binary Search to find the integer square root.
 * - Handle small values (x <= 1) directly.
 * - Search in the range [1, x / 2].
 * - For a given mid:
 *   - If mid <= x / mid, mid is a valid candidate, store it and move right.
 *   - Otherwise, move left.
 * - Continue until the search space is exhausted.
 * - Return the last valid candidate.
 *
 * Time Complexity: O(log x)
 *   - Binary search reduces the range by half each step.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Uses division (x / mid) to avoid integer overflow.
 * - Correctly handles x = 0 and x = 1.
 * - Ensures the result is rounded down.
 */

class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;

        int left = 1, right = x / 2;
        int ans = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

