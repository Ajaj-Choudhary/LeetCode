/*
 * LeetCode 13. Roman to Integer
 * Difficulty: Easy
 *
 * Approach:
 * - Use a HashMap to store Roman numeral values.
 * - Traverse the string from right to left.
 * - If the current value is smaller than the previous value,
 *   subtract it; otherwise, add it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < prev) {
                res -= curr;
            } else {
                res += curr;
            }
            prev = curr;
        }
        return res;
    }
}
