/*
 * LeetCode 147. Insertion Sort List
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given the head of a singly linked list, sort the list using
 *   insertion sort and return the sorted list's head.
 *
 * Approach / Algorithm:
 * - Use a dummy node to maintain a sorted portion of the list.
 * - Traverse the original list node by node.
 * - For each node:
 *   - Find the correct position in the sorted list.
 *   - Insert the node at that position.
 * - Continue until all nodes are processed.
 *
 * Time Complexity: O(n²)
 *   - Each insertion may traverse the sorted part of the list.
 *
 * Space Complexity: O(1)
 *   - Sorting is done in-place using constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles empty list and single-node list.
 * - Uses a dummy node to simplify insertion at the head.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}

