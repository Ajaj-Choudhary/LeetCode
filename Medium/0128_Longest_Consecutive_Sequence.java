/*
 * LeetCode 128. Longest Consecutive Sequence
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an unsorted array of integers nums,
 *   return the length of the longest consecutive elements sequence.
 * - You must write an algorithm that runs in O(n) time.
 *
 * Approach / Algorithm:
 * - Use a HashSet to store all numbers for O(1) lookup.
 * - For each number:
 *     - Only start counting if (num - 1) does NOT exist in the set
 *       → ensures we start from the beginning of a sequence.
 *     - Expand forward while (num + 1) exists.
 * - Track the maximum length found.
 *
 * Time Complexity: O(n)
 *   - Each element is processed at most twice.
 *
 * Space Complexity: O(n)
 *   - HashSet stores all elements.
 *
 * Edge Cases:
 * - Empty array → return 0.
 */

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int current : set) {
            // Start only if it's the beginning of a sequence
            if (!set.contains(current - 1)) {
                int next = current;
                int count = 1;

                while (set.contains(next + 1)) {
                    next++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
