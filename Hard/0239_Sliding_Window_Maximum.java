/*
 * LeetCode 239. Sliding Window Maximum
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - You are given an array of integers nums and a sliding window of size k.
 * - The sliding window moves from the left to the right by one position at a time.
 * - Return the maximum value in each sliding window.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - 1 <= k <= nums.length
 *
 * Key Observation:
 *
 * - Use a deque to maintain indices of elements in decreasing order of their values.
 * - Remove indices outside the current window and smaller elements from the back so the front always contains the maximum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}