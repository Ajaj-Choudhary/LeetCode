/*
 * LeetCode 907. Sum of Subarray Minimums
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an array of integers arr, find the sum of min(b), where b ranges over every contiguous subarray of arr.
 * - Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * Constraints:
 *
 * - 1 <= arr.length <= 3 * 10^4
 * - 1 <= arr[i] <= 3 * 10^4
 *
 * Key Observation:
 *
 * - For each element, find its previous smaller element and next smaller element using monotonic stacks.
 * - The number of subarrays where arr[i] is the minimum is the product of the number of choices on its left and right.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = getPSE(arr);
        int[] nse = getNSE(arr);

        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total = (total + (left * right) % MOD * arr[i]) % MOD;
        }

        return (int) total;
    }

    private int[] getPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    private int[] getNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}