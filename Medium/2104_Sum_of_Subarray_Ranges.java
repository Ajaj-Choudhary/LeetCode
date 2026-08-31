/*
 * LeetCode 2104. Sum of Subarray Ranges
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given an integer array nums.
 * - The range of a subarray is the difference between the largest and smallest element in the subarray.
 * - Return the sum of all subarray ranges of nums.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 1000
 * - -10^9 <= nums[i] <= 10^9
 *
 * Key Observation:
 *
 * - Calculate the contribution of every element as the maximum of its subarrays using previous greater-or-equal and next greater elements.
 * - Similarly, calculate its contribution as the minimum using previous smaller-or-equal and next smaller elements, then subtract the total minimum contribution from the total maximum contribution.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfSumArrayMax(nums) - sumOfSubArrayMin(nums);
    }

    private long sumOfSumArrayMax(int[] nums) {
        int n = nums.length;

        int[] nge = getNGE(nums);
        int[] pgee = getPGEE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int left = nge[i] - i;
            int right = i - pgee[i];

            long count = (long) left * right;
            sum += (count * nums[i]);
        }

        return sum;
    }

    private long sumOfSubArrayMin(int[] nums) {
        int n = nums.length;

        int[] nse = getNSE(nums);
        int[] psee = getPSEE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int left = nse[i] - i;
            int right = i - psee[i];

            long count = (long) left * right;
            sum += (count * nums[i]);
        }

        return sum;
    }

    private int[] getNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nge[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return nge;
    }

    private int[] getPGEE(int[] nums) {
        int n = nums.length;
        int[] pgee = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            pgee[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return pgee;
    }

    private int[] getNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nse[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return nse;
    }

    private int[] getPSEE(int[] nums) {
        int n = nums.length;
        int[] psee = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            psee[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return psee;
    }
}