/*
 * LeetCode 735. Asteroid Collision
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given an array asteroids representing asteroids in a row.
 * - The absolute value represents the size of an asteroid, while the sign represents its direction.
 * - Return the state of the asteroids after all collisions.
 *
 * Constraints:
 *
 * - 2 <= asteroids.length <= 10^4
 * - -1000 <= asteroids[i] <= 1000
 * - asteroids[i] != 0
 *
 * Key Observation:
 *
 * - Use a stack to maintain the asteroids that are currently alive.
 * - A collision can only occur when the current asteroid is moving left and the stack top is moving right. Keep resolving collisions until one asteroid survives or both are destroyed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0 && !st.isEmpty() && st.peek() >= 0) {
                int top = st.peek();
                if (top < -asteroid) {
                    st.pop();
                } else if (top == -asteroid) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.push(asteroid);
            }

        }

        int[] result = new int[st.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}