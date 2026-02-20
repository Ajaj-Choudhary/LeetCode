/*
 * LeetCode 12. Integer to Roman
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an integer, convert it to a Roman numeral.
 * - Roman numerals are formed by appending symbols from highest to lowest.
 * - Special subtractive cases must be handled:
 *   4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD), 900 (CM).
 *
 * Approach / Algorithm:
 * - Predefine Roman representations for:
 *      • Units (1–9)
 *      • Tens (10–90)
 *      • Hundreds (100–900)
 * - Handle thousands separately using "M".
 * - Build the result by:
 *      1. Adding thousands
 *      2. Adding hundreds
 *      3. Adding tens
 *      4. Adding units
 * - Use indexing to directly fetch correct Roman parts.
 *
 * Time Complexity: O(1)
 *   - Maximum number size is bounded (≤ 3999).
 *
 * Space Complexity: O(1)
 *   - Uses fixed-size arrays.
 *
 * Important Details / Edge Cases:
 * - Handles subtractive notation correctly.
 * - Efficient since no loops over values repeatedly.
 */

class Solution {
    private static final String[] UNITS = {
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
    };

    private static final String[] TENS = {
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
    };

    private static final String[] HUNDREDS = {
            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        sb.append("M".repeat(num / 1000));
        sb.append(HUNDREDS[(num / 100) % 10]);
        sb.append(TENS[(num / 10) % 10]);
        sb.append(UNITS[num % 10]);

        return sb.toString();
    }
}
