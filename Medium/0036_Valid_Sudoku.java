/*
 * LeetCode 36. Valid Sudoku
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Determine if a 9 x 9 Sudoku board is valid.
 * - Only the filled cells need to be validated.
 * - The board is valid if:
 *   1. Each row contains digits 1–9 without repetition.
 *   2. Each column contains digits 1–9 without repetition.
 *   3. Each of the nine 3 x 3 sub-boxes contains digits 1–9 without repetition.
 *
 * Approach / Algorithm:
 * - Use three boolean matrices:
 *   - rows[9][9] to track digits used in each row.
 *   - cols[9][9] to track digits used in each column.
 *   - boxes[9][9] to track digits used in each 3x3 sub-box.
 * - Traverse each cell in the board:
 *   - Skip empty cells ('.').
 *   - Convert the character digit to an index (digit - '1').
 *   - Compute the sub-box index using:
 *       boxIndex = (row / 3) * 3 + (col / 3)
 * - If the digit is already seen in the corresponding row, column, or box, return false.
 * - Otherwise, mark the digit as seen.
 *
 * Time Complexity: O(1)
 *   - The board size is fixed at 9 x 9.
 *
 * Space Complexity: O(1)
 *   - Uses fixed-size auxiliary arrays.
 *
 * Important Details / Edge Cases:
 * - Empty cells are ignored.
 * - Validity is checked only, not solvability.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                int ch = board[r][c];
                if (ch == '.')
                    continue;

                int digit = ch - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][digit] || cols[c][digit] || boxes[boxIndex][digit]) {
                    return false;
                }

                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }
        return true;
    }
}

