/*
 * LeetCode 21. Merge Two Sorted Lists
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given the heads of two sorted linked lists, merge them into one sorted list.
 * - The merged list should be made by splicing together the nodes of the first two lists.
 * - Return the head of the merged linked list.
 *
 * 🧠 Approach / Algorithm:
 * - Use a dummy node to simplify pointer handling.
 * - Maintain a pointer `head` that always points to the last node
 *   of the merged list.
 * - Traverse both linked lists simultaneously:
 *   - Compare the current nodes of both lists.
 *   - Attach the node with the smaller value to the merged list.
 *   - Move the pointer of the selected list forward.
 * - Move the `head` pointer forward after each insertion.
 * - Once one list becomes null, attach the remaining nodes of the
 *   other list directly to the merged list.
 * - Return `dummy.next` as the head of the merged list.
 *
 * Time Complexity: O(n + m)
 *   - n = number of nodes in list1
 *   - m = number of nodes in list2
 *
 * Space Complexity: O(1)
 *   - No extra data structures are used; nodes are reused.
 *
 * Important Details / Edge Cases:
 * - Handles cases where one or both lists are null.
 * - Maintains sorted order since both input lists are already sorted.
 * - Using a dummy node avoids special handling for the head node.
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = list2 == null ? list1 : list2;
        return dummy.next;
    }
}
