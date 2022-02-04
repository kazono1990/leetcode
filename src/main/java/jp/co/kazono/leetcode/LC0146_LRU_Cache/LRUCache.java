package jp.co.kazono.leetcode.LC0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head = new Node(0, 0);;
    private Node tail = new Node(0, 0);;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNodeFromCache(node);
            insertToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNodeFromCache(node);
            node.value = value;
            insertToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                removeNodeFromCache(tail.prev);
            }
            Node node = new Node(key, value);
            insertToHead(node);
            cache.put(key, node);
        }
    }

    private void removeNodeFromCache(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}
