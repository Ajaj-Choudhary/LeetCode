/*
 * LeetCode 1004. Max Consecutive Ones III
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a binary array nums and an integer k, return the maximum number of
 *   consecutive 1s in the array if you can flip at most k 0s.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1.
 * - 0 <= k <= nums.length
 *
 * Key Observation:
 *
 * - Use a sliding window and keep track of the number of zeros in the window.
 * - When the number of zeros exceeds k, move the left pointer forward until
 *   the window becomes valid again.
 * - Since the left pointer only moves when necessary, the final window length
 *   is the maximum valid window length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zero = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }

            if (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
        }

        return nums.length - left;
    }
}