/*
 * LeetCode 24. Swap Nodes in Pairs
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a linked list, swap every two adjacent nodes and return its head.
 * - You must solve the problem without modifying the values in the list's nodes
 *   (i.e., only nodes themselves may be changed).
 *
 * Approach / Algorithm:
 * - Use an iterative approach with a dummy node to simplify edge cases.
 * - The dummy node points to the head of the list.
 * - Maintain a pointer `prev` that always points to the node before the pair
 *   to be swapped.
 * - While there are at least two nodes ahead:
 *   - Identify the first and second nodes of the current pair.
 *   - Adjust pointers to swap the pair.
 *   - Move `prev` forward to the end of the swapped pair.
 * - Continue until no more pairs are available.
 * - Return dummy.next as the new head of the list.
 *
 * Time Complexity: O(n)
 *   - n = number of nodes in the linked list.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles empty lists and lists with a single node correctly.
 * - Dummy node avoids special handling for the head swap.
 * - Swapping is done by pointer manipulation only.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}

