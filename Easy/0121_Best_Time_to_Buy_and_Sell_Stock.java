/*
 * LeetCode 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 * - You want to maximize your profit by choosing a single day to buy one stock
 *   and choosing a different day in the future to sell that stock.
 * - Return the maximum profit you can achieve. If no profit is possible, return 0.
 *
 * Approach / Algorithm:
 * - Traverse the prices array once.
 * - Maintain:
 *   - minPrice: the minimum stock price seen so far.
 *   - maxProfit: the maximum profit achievable so far.
 * - For each price:
 *   - If the price is lower than minPrice, update minPrice.
 *   - Otherwise, calculate the profit by selling at the current price
 *     and update maxProfit if it is greater.
 * - Return maxProfit after the traversal completes.
 *
 * Time Complexity: O(n)
 *   - n = number of days.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Ensures the buy happens before the sell.
 * - Returns 0 if prices are strictly decreasing.
 * - Works correctly for arrays with one element.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
