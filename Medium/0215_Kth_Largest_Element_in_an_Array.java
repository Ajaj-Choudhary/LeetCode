/*
 * LeetCode 215. Kth Largest Element in an Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an integer array nums and an integer k,
 *   return the k-th largest element in the array.
 * - It is the k-th largest element in sorted order,
 *   not the k-th distinct element.
 *
 * Constraint:
 * - Must be solved efficiently without fully sorting the array.
 *
 * Approach / Algorithm (QuickSelect):
 * - Use the QuickSelect algorithm (based on QuickSort partitioning).
 * - Convert the problem into finding the (n - k)-th smallest element.
 * - Partition the array around a pivot:
 *     - Elements smaller than pivot go left.
 *     - Elements larger go right.
 * - Recursively search only the side that contains the target index.
 *
 * Time Complexity:
 * - Average Case: O(n)
 * - Worst Case: O(n²) (rare, depends on pivot choice)
 *
 * Space Complexity:
 * - O(1) extra space (in-place), O(log n) recursion stack on average.
 *
 * Important Details / Edge Cases:
 * - Works with duplicate elements.
 * - Does not require full sorting.
 * - In-place algorithm for optimal space usage.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

