/*
 * LeetCode 19. Remove Nth Node From End of List
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given the head of a singly linked list, remove the n-th node
 *   from the end of the list and return its head.
 *
 * Approach / Algorithm:
 * - Use the two-pointer technique with a dummy node.
 * - Create a dummy node pointing to the head to handle edge cases
 *   (such as removing the first node).
 * - Initialize two pointers, fast and slow, at the dummy node.
 * - Move the fast pointer n steps ahead.
 * - Move both fast and slow pointers together until fast reaches
 *   the last node.
 * - The slow pointer will be positioned just before the node to remove.
 * - Update slow.next to skip the target node.
 * - Return dummy.next as the new head of the list.
 *
 * Time Complexity: O(n)
 *   - n = number of nodes in the linked list.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Correctly handles removing the head node.
 * - Dummy node simplifies pointer manipulation.
 * - Assumes n is always valid.
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}

