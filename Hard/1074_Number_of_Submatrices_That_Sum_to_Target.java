/*
 * LeetCode 1074. Number of Submatrices That Sum to Target
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Given a matrix and a target, return the number of non-empty submatrices
 *   that sum to target.
 * - A submatrix is a rectangular section of the matrix.
 * - Two submatrices are different if they have any different coordinates.
 *
 * Constraints:
 *
 * - 1 <= matrix.length <= 100
 * - 1 <= matrix[0].length <= 100
 * - -1000 <= matrix[i][j] <= 1000
 * - -10^8 <= target <= 10^8
 *
 * Key Observation:
 *
 * - Convert each row into a prefix-sum array so that the sum between any two
 *   columns can be calculated in O(1).
 * - Fix the left and right column boundaries and reduce the problem to finding
 *   the number of subarrays with sum equal to target across the rows.
 * - Use a HashMap of prefix sums to count those subarrays efficiently.
 *
 * Time Complexity: O(rows * cols^2)
 * Space Complexity: O(rows)
 */

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int result = 0;

        for (int left = 0; left < cols; left++) {
            for (int right = left; right < cols; right++) {
                result += countSubarraysWithSum(matrix, rows, left, right, target);
            }
        }

        return result;
    }

    private int countSubarraysWithSum(int[][] matrix, int rows, int left, int right, int target) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int sum = 0, count = 0;

        for (int row = 0; row < rows; row++) {
            sum += matrix[row][right] - (left > 0 ? matrix[row][left - 1] : 0);
            count += prefixCount.getOrDefault(sum - target, 0);
            prefixCount.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}