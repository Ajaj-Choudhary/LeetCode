/*
 * LeetCode 74. Search a 2D Matrix
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given an m x n integer matrix with the following properties:
 *   - Each row is sorted in non-decreasing order.
 *   - The first integer of each row is greater than the last integer of the previous row.
 * - Given an integer target, return true if target is present in the matrix, otherwise false.
 *
 * Approach / Algorithm:
 * - Treat the 2D matrix as a flattened 1D sorted array.
 * - Perform Binary Search on indices from 0 to (m * n - 1).
 * - Convert a 1D index to 2D indices using:
 *   - row = mid / n
 *   - col = mid % n
 * - Compare the matrix value with target and adjust search range accordingly.
 *
 * Time Complexity: O(log(m * n))
 *   - Binary search over all elements.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works because matrix follows strict row-wise ordering.
 * - Avoids extra memory by not creating a separate array.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

