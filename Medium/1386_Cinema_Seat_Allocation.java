/*
 * LeetCode 1386. Cinema Seat Allocation
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - A cinema has n rows of seats, with 10 seats in each row.
 * - Given reservedSeats, where reservedSeats[i] = [rowi, seati] means that seat is reserved.
 * - A four-person group must be assigned to four seats in the same row using one of the allowed seat blocks.
 * - Return the maximum number of four-person groups that can be assigned.
 *
 * Constraints:
 *
 * - 1 <= n <= 10^9
 * - 0 <= reservedSeats.length <= min(10 * n, 10^4)
 * - reservedSeats[i].length == 2
 * - 1 <= reservedSeats[i][0] <= n
 * - 1 <= reservedSeats[i][1] <= 10
 * - All reservedSeats[i] are distinct.
 *
 * Key Observation:
 *
 * - Use a bitmask for each row to represent its reserved seats and predefined masks for the three possible four-seat blocks.
 * - Rows without any reserved seats can always accommodate two groups, while rows with reservations are checked against each possible block.
 *
 * Time Complexity: O(m)
 * Space Complexity: O(m)
 */

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> d = new HashMap<>();

        for (var e : reservedSeats) {
            int i = e[0], j = e[1];
            d.merge(i, 1 << (10 - j), (x, y) -> x | y);
        }

        int[] masks = { 0b0111100000, 0b0000011110, 0b0001111000 };

        int ans = (n - d.size()) * 2;

        for (int x : d.values()) {
            for (int mask : masks) {
                if ((x & mask) == 0) {
                    x |= mask;
                    ++ans;
                }
            }
        }
        return ans;
    }
}