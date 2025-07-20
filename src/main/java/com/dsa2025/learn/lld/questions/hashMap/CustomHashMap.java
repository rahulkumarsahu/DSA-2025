package com.dsa2025.learn.lld.questions.hashMap;

/**
 * A simple custom HashMap implementation using array and linked list for collision handling.
 *
 * @param <K>
 * @param <V>
 */
public class CustomHashMap <K, V> {

    /**
     * Node to store the key value pairs in a linked list
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> {

        K key;
        V value;
        Node<K, V> next; // for hash collision

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array to store the linked list [,,,,,,,,,,,,,,] every index their will be linked list
    private Node<K, V>[] buckets;
    private int size;
    private int capacity;

    // when to resize -> when 75% Full
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        capacity = 16;
        this.buckets = new Node[capacity];
        size = 0;
    }

    /**
     * Get the bucket index for a key using hash function in which index we will store the upcoming key, value pair
     */
    private int getIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Check if key exists
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Resize the hash table when it gets too full
     */
    @SuppressWarnings("unchecked")
    private void resize() {

        // save old data
        Node<K, V>[] oldBuckets = buckets;
        int oldCapacity = capacity;

        // double the capacity
        capacity = capacity * 2;
        buckets = new Node[capacity];
        size = 0;

        // Move all elements to new buckets
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> current = oldBuckets[i];
            while (current != null) {
                put(current.key, current.value); // Re-add to new table
                current = current.next;
            }
        }

    }

    /**
     * Get value for a key
     */
    public V get(K key) {
        // always hash will be the same for a key
        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        // search through the linked list
        while (current != null) {
            // current key matches return the value
            if (current.key != null && current.key.equals(key)) {
                return current.value;
            }
            // else search the next node.
            current = current.next;
        }
        return null;
    }

    /**
     * Add or update a key-value pair
     */
    public void put(K key, V value) {
        // check if we need to resize when capacity is 75% full
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
        // to store the value, we should get the index where we have to store the value
        int index = getIndex(key);
        // get the value from bucket index because of hash collision
        Node<K, V> head = buckets[index];

        // if the bucket is empty, create the first node
        if (head == null) {
            buckets[index] = new Node<>(key, value);
            size++;
            return;
        }

        // Search for an existing key in the linked list
        Node<K, V> current = head;
        while (true) {
            if (current.key != null && current.key.equals(key)) {
                current.value = value; // Update existing key
                return;
            }
            if (current.next == null) break;
            current = current.next;
        }

        // Key not found, add new node at the end
        current.next = new Node<>(key, value);
        size++;
    }

    /**
     * Remove a key-value pair
     */
    public V remove(K key) {

        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        // Search for the key
        while (current != null) {
            if (current.key != null && current.key.equals(key)) {
                V value = current.value;

                if (prev == null) {
                    // Removing first node
                    buckets[index] = current.next;
                } else {
                    // Removing middle or last node
                    prev.next = current.next;
                }

                size--;
                return value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    /**
     * Get number of key-value pairs
     */
    public int size() {
        return size;
    }

    /**
     * Check if map is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Display all key-value pairs
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        // its array, so one by one every value will come
        // which can and cannot contain the linked list.
        for (Node<K, V> head : buckets) {
            //get the linked list, and if it is not null to iterate and print the value
            Node<K, V> current = head;
            while (current != null) {
                // the first we have taken to append the comma
                if (!first) sb.append(", ");
                sb.append(current.key).append("=").append(current.value);
                first = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }

}
