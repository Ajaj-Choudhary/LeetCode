/*
 * LeetCode 6. Zigzag Conversion
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a string s and an integer numRows, write the string in a zigzag pattern
 *   on the given number of rows.
 * - After writing the string in a zigzag form, read it row by row and return
 *   the resulting string.
 *
 * Approach / Algorithm:
 * - If numRows is 1, the zigzag pattern is the same as the original string,
 *   so return s directly.
 * - Use a StringBuilder to build the final result.
 * - The zigzag pattern follows a repeating cycle of length 2 * (numRows - 1).
 * - Iterate row by row:
 *   - For each row, jump through the string using the cycle length.
 *   - Always append the vertical characters.
 *   - For middle rows, also append the diagonal characters if they are within bounds.
 * - Continue until all rows are processed.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(n)
 *   - Uses extra space for the result string.
 *
 * Important Details / Edge Cases:
 * - When numRows == 1, return the original string.
 * - First and last rows contain only vertical characters.
 * - Middle rows contain both vertical and diagonal characters.
 */

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        int increment = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j+=2*(numRows-1)) {
                str.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && j + increment < s.length()) {
                    str.append((s.charAt(j + increment)));
                }
            }
            increment -= 2;
        }

        return str.toString();
    }
}

