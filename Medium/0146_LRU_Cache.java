/*
 * LeetCode 146. LRU Cache
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Design a data structure that follows the constraints of a Least Recently
 *   Used (LRU) cache.
 * - Implement get(key) to return the value if the key exists, otherwise -1.
 * - Implement put(key, value) to update or add a key-value pair. If the cache
 *   exceeds its capacity, evict the least recently used key.
 * - Both get and put must run in O(1) average time.
 *
 * Constraints:
 *
 * - 1 <= capacity <= 3000
 * - 0 <= key <= 10^4
 * - 0 <= value <= 10^5
 * - At most 2 * 10^5 calls will be made to get and put.
 *
 * Key Observation:
 *
 * - Use a HashMap to find each key's node in O(1) average time.
 * - Use a doubly linked list to maintain the usage order, with the most
 *   recently used node at the front and the least recently used node at the back.
 * - On every get or put, move the corresponding node to the front.
 *
 * Time Complexity: O(1) average for get and put
 * Space Complexity: O(capacity)
 */

class LRUCache {
    private static class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertAtFront(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */