/*
 * LeetCode 219. Contains Duplicate II
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given an integer array nums and an integer k,
 *   return true if there exist two distinct indices i and j
 *   such that nums[i] == nums[j] and abs(i - j) <= k.
 * - Otherwise, return false.
 *
 * 🧠 Approach / Algorithm:
 * - Use a sliding window technique with a HashSet.
 * - The HashSet stores elements within a window of size at most k.
 * - Traverse the array using index i:
 *   - If i > k, remove the element that is out of the current window
 *     (nums[i - k - 1]).
 *   - Attempt to add nums[i] to the HashSet.
 *   - If the element already exists, a duplicate within distance k
 *     is found, so return true.
 * - If the loop completes without finding such a pair, return false.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(k)
 *   - The HashSet stores at most k elements.
 *
 * Important Details / Edge Cases:
 * - Works efficiently for large input sizes.
 * - Handles cases where k = 0 (no valid duplicates possible).
 * - Ensures only elements within distance k are compared.
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
