/*
 * LeetCode 20. Valid Parentheses
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a string containing only the characters '(', ')', '{', '}', '[' and ']',
 *   determine if the input string is valid.
 * - An input string is valid if:
 *   - Open brackets are closed by the same type of brackets.
 *   - Open brackets are closed in the correct order.
 *   - Every closing bracket has a corresponding opening bracket.
 *
 * 🧠 Approach / Algorithm:
 * - Use a stack to track opening brackets.
 * - Traverse each character in the string:
 *   - If the character is an opening bracket '(', '[', or '{',
 *     push it onto the stack.
 *   - If the character is a closing bracket:
 *     - If the stack is empty, return false (no matching opening bracket).
 *     - Pop the top element from the stack.
 *     - Check if the popped opening bracket matches the current closing bracket.
 *       If not, return false.
 * - After processing all characters, check if the stack is empty.
 *   - If empty, the string is valid.
 *   - Otherwise, return false.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(n)
 *   - In the worst case, all characters are opening brackets.
 *
 * Important Details / Edge Cases:
 * - Handles nested and sequential brackets correctly.
 * - Returns false if a closing bracket appears before any opening bracket.
 * - Ensures no unmatched opening brackets remain at the end.
 */

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((top == '(' && c != ')') ||
                        (top == '[' && c != ']') ||
                        (top == '{' && c != '}'))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
