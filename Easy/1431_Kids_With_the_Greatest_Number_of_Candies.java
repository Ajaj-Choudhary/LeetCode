/*
 * LeetCode 1431. Kids With the Greatest Number of Candies
 * Difficulty: Easy
 *
 * Problem Statement:
 * - There are n kids with candies, where candies[i] represents
 *   the number of candies the i-th kid has.
 * - You are also given an integer extraCandies.
 * - Return a boolean array result of length n, where result[i] is true
 *   if after giving the i-th kid all the extraCandies, they will have
 *   the greatest number of candies among all kids, otherwise false.
 *
 * Approach / Algorithm:
 * - First, find the maximum number of candies any kid currently has.
 * - Then, iterate through the candies array again:
 *   - For each kid, check if candies[i] + extraCandies is greater than
 *     or equal to the maximum.
 *   - Store the result (true or false) in a list.
 * - Return the resulting list.
 *
 * Time Complexity: O(n)
 *   - n = number of kids.
 *
 * Space Complexity: O(n)
 *   - Space used for the result list.
 *
 * Important Details / Edge Cases:
 * - Multiple kids can have the greatest number of candies.
 * - The original candies array is not modified.
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}

