/*
 * LeetCode 460. LFU Cache
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * - get(key) returns the value if the key exists, otherwise -1.
 * - put(key, value) inserts or updates a key-value pair. If capacity is exceeded,
 *   evict the least frequently used key. If multiple keys have the same frequency,
 *   evict the least recently used key among them.
 * - Both get and put must run in O(1) average time.
 *
 * Constraints:
 *
 * - 1 <= capacity <= 10^4
 * - 0 <= key <= 10^5
 * - 0 <= value <= 10^9
 * - At most 2 * 10^5 calls will be made to get and put.
 *
 * Key Observation:
 *
 * - Use a HashMap to map each key to its corresponding node.
 * - Maintain a separate doubly linked list for every frequency.
 * - Maintain minFreq to identify the frequency from which the next node should
 *   be evicted.
 * - Within each frequency list, keep the most recently used node at the front
 *   and the least recently used node at the back.
 *
 * Time Complexity: O(1) average for get and put
 * Space Complexity: O(capacity)
 */

class LFUCache {
    private static class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLRU() {
            if (size == 0) {
                return null;
            }

            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DoublyLinkedList minList = freqMap.get(minFreq);
            Node evicted = minList.removeLRU();
            if (minList.size == 0) {
                freqMap.remove(minList);
            }
            keyMap.remove(evicted.key);
        }

        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);
        freqMap.computeIfAbsent(1, f -> new DoublyLinkedList()).addFront(newNode);
        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldList.size == 0) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new DoublyLinkedList()).addFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */