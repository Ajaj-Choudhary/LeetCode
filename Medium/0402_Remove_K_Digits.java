/*
 * LeetCode 402. Remove K Digits
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a string num representing a non-negative integer and an integer k, remove k digits from num.
 * - Return the smallest possible integer after removing k digits.
 *
 * Constraints:
 *
 * - 1 <= num.length <= 10^5
 * - num consists of only digits.
 * - num does not have any leading zeros except for the number 0 itself.
 * - 0 <= k <= num.length
 *
 * Key Observation:
 *
 * - Use a monotonic increasing StringBuilder to remove larger digits that appear before smaller digits while k removals remain.
 * - After processing all digits, remove any remaining digits from the end and then remove leading zeros.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int i = 0;
        while (i < stack.length() - 1 && stack.charAt(i) == '0') {
            i++;
        }
        stack.delete(0, i);

        return stack.length() == 0 ? "0" : stack.toString();
    }
}