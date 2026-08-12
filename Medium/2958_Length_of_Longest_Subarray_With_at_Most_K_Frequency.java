/*
 * LeetCode 2958. Length of Longest Subarray With at Most K Frequency
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given an integer array nums and an integer k.
 * - An array is called good if the frequency of each element is less than or equal to k.
 * - Return the length of the longest good subarray of nums.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - 1 <= k <= nums.length
 *
 * Key Observation:
 *
 * - Use a sliding window with a HashMap to maintain the frequency of each element.
 * - When the frequency of the current element exceeds k, move the left pointer until the window becomes valid again.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.get(num) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}