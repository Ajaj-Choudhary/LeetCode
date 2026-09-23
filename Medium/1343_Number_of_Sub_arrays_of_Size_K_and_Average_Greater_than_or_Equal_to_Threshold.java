/*
 * LeetCode 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an integer array arr and integers k and threshold, return the number
 *   of sub-arrays of size k whose average is greater than or equal to threshold.
 *
 * Constraints:
 *
 * - 1 <= arr.length <= 10^5
 * - 1 <= arr[i] <= 10^4
 * - 1 <= k <= arr.length
 * - 0 <= threshold <= 10^4
 *
 * Key Observation:
 *
 * - For a sub-array of size k, its average is at least threshold if its sum
 *   is at least k * threshold.
 * - Maintain the sum of the current window using a sliding window.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        int target = k * threshold;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= target) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];

            if (sum >= target) {
                count++;
            }
        }

        return count;
    }
}