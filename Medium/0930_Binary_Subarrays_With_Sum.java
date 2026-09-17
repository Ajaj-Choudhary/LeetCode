/*
 * LeetCode 930. Binary Subarrays With Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a binary array nums and an integer goal, return the number of
 *   non-empty subarrays with a sum equal to goal.
 * - A subarray is a contiguous part of the array.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 3 * 10^4
 * - nums[i] is either 0 or 1.
 * - 0 <= goal <= nums.length
 *
 * Key Observation:
 *
 * - Use a sliding window to maintain a subarray whose sum is at most goal.
 * - zerosBefore counts the extra subarrays created by leading zeros while
 *   the current window has sum equal to goal.
 * - When the sum becomes greater than goal, move the left pointer until the
 *   window becomes valid again.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, sum = 0, zerosBefore = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left < right && (nums[left] == 0 || sum > goal)) {
                if (nums[left] == 1) {
                    sum--;
                    zerosBefore = 0;
                } else {
                    zerosBefore++;
                }
                left++;
            }

            if (sum == goal) {
                count += zerosBefore + 1;
            }
        }

        return count;
    }
}