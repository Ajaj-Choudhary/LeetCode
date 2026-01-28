/*
 * LeetCode 1200. Minimum Absolute Difference
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given an array of distinct integers arr, find all pairs of elements
 *   with the minimum absolute difference.
 * - Return a list of pairs in ascending order.
 *
 * 🧠 Approach / Algorithm:
 * - Sort the input array to bring close values next to each other.
 * - Initialize a variable minDiff to track the smallest difference found.
 * - Traverse the sorted array from index 1 to end:
 *   - Compute the difference between the current element and the previous element.
 *   - If the difference is smaller than minDiff:
 *     - Clear the result list.
 *     - Update minDiff.
 *     - Add the current pair to the result.
 *   - If the difference equals minDiff:
 *     - Add the current pair to the result.
 * - Return the list of pairs.
 *
 * Time Complexity: O(n log n)
 *   - n = number of elements in the array (due to sorting).
 *
 * Space Complexity: O(1)
 *   - Extra space is used only for the output list.
 *
 * Important Details / Edge Cases:
 * - Works correctly for negative and positive integers.
 * - Sorting ensures pairs are processed in ascending order.
 * - Assumes all elements in the array are distinct.
 */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff < minDiff) {
                result.clear();
                minDiff = diff;
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
