/*
 * LeetCode 901. Online Stock Span
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Design an algorithm that collects daily stock prices and returns the span of the stock's price for the current day.
 * - The span is the maximum number of consecutive days ending today for which the stock price was less than or equal to today's price.
 * - Implement the StockSpanner class with a constructor and a next method.
 *
 * Constraints:
 *
 * - 1 <= price <= 10^5
 * - At most 10^4 calls will be made to next.
 *
 * Key Observation:
 *
 * - Use a monotonic decreasing stack storing each price along with its span.
 * - When the current price is greater than or equal to the stack's top price, merge the top span into the current span.
 *
 * Time Complexity: O(1) amortized per next call
 * Space Complexity: O(n)
 */

class StockSpanner {
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */