/*
 * LeetCode 1095. Find in Mountain Array
 * Difficulty: Hard
 *
 * Problem Statement:
 * - You are given a mountain array accessed through the MountainArray interface.
 * - A mountain array increases strictly to a peak element and then strictly decreases.
 * - Given a target value, return the minimum index such that
 *   mountainArr.get(index) == target.
 * - If the target does not exist, return -1.
 * - Direct access to the array is not allowed; only MountainArray.get() and
 *   MountainArray.length() can be used.
 *
 * Approach / Algorithm:
 * - First, find the peak index of the mountain array using binary search.
 * - Perform binary search on the left side of the peak (ascending order).
 *   - If the target is found, return its index immediately.
 * - If not found, perform binary search on the right side of the peak
 *   (descending order).
 * - If the target is still not found, return -1.
 *
 * Time Complexity: O(log n)
 *   - Finding the peak takes O(log n).
 *   - Each binary search also takes O(log n).
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Uses only the MountainArray API methods as required.
 * - Carefully handles ascending and descending binary searches.
 * - Returns the minimum index of the target if it appears on both sides.
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakElement(mountainArr);

        int leftResult = binarySearch(mountainArr, target, 0, peak, true);
        if (leftResult != -1) {
            return leftResult;
        }

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    public int peakElement(MountainArray arr) {
        int left = 0, right = arr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(MountainArray arr, int target, int left, int right, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (isAscending) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
