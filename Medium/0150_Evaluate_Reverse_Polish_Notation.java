/*
 * LeetCode 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an array of strings representing an arithmetic expression in Reverse Polish Notation.
 * - Evaluate the expression using +, -, *, and / operators.
 * - Return the integer result, with division truncating toward zero.
 *
 * Constraints:
 *
 * - 1 <= tokens.length <= 10^4
 * - tokens[i] is either an operator or an integer in the range [-200, 200].
 * - The input represents a valid arithmetic expression in Reverse Polish Notation.
 * - There will be no division by zero.
 * - The answer and all intermediate calculations fit in a 32-bit integer.
 *
 * Key Observation:
 *
 * - Use a stack to store operands.
 * - For every operator, pop the two operands, apply the operation in the correct order, and push the result back.
 * - After processing all tokens, the stack contains the final result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }

        return stack.pop();
    }
}