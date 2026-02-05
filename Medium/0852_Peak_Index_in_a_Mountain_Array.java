/*
 * LeetCode 852. Peak Index in a Mountain Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - An array arr is a mountain array if:
 *   - arr.length >= 3
 *   - There exists some index i such that:
 *       arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *       arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * - Return the index i of the peak element.
 *
 * Approach / Algorithm:
 * - Use Binary Search since the array strictly increases then decreases.
 * - Initialize two pointers left and right.
 * - Find mid and compare arr[mid] with arr[mid + 1]:
 *   - If arr[mid] < arr[mid + 1], the peak lies on the right side.
 *   - Otherwise, the peak lies on the left side or at mid.
 * - Continue until left equals right.
 * - Return left as the peak index.
 *
 * Time Complexity: O(log n)
 *   - Binary search reduces the search space each iteration.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - The mountain property guarantees the existence of exactly one peak.
 * - arr[mid + 1] is safe because left < right ensures mid < right.
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

