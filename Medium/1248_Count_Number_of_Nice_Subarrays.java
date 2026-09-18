/*
 * LeetCode 1248. Count Number of Nice Subarrays
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an array of integers nums and an integer k, a subarray is called
 *   nice if there are exactly k odd numbers in it.
 * - Return the number of nice subarrays.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 50000
 * - 1 <= nums[i] <= 10^5
 * - 1 <= k <= nums.length
 *
 * Key Observation:
 *
 * - Use a sliding window to maintain exactly k odd numbers.
 * - evenPrefix counts the consecutive even numbers before the first odd
 *   number in the current valid window.
 * - When oddCount == k, there are evenPrefix + 1 possible starting positions
 *   for the current right endpoint.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, oddCount = 0, evenPrefix = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (isOdd(nums[right])) {
                oddCount++;
            }

            while (left < right && (oddCount > k || !isOdd(nums[left]))) {
                if (isOdd(nums[left])) {
                    oddCount--;
                    evenPrefix = 0;
                } else {
                    evenPrefix++;
                }
                left++;
            }

            if (oddCount == k) {
                count += evenPrefix + 1;
            }
        }

        return count;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}