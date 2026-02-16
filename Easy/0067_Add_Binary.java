/*
 * LeetCode 67. Add Binary
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given two binary strings a and b, return their sum as a binary string.
 * - The strings contain only '0' and '1'.
 * - The result should not contain leading zeros (except "0" itself).
 *
 * Approach / Algorithm:
 * - Use two pointers starting from the end of both strings.
 * - Add corresponding bits along with a carry.
 * - Append (sum % 2) to the result.
 * - Update carry as (sum / 2).
 * - Continue until both strings are processed and no carry remains.
 * - Reverse the result at the end.
 *
 * Time Complexity: O(n)
 *   - Where n is the length of the longer string.
 *
 * Space Complexity: O(n)
 *   - For storing the resulting binary string.
 *
 * Important Details / Edge Cases:
 * - Handles different length strings.
 * - Handles leftover carry after processing both strings.
 * - Uses StringBuilder for efficient string manipulation.
 */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}

