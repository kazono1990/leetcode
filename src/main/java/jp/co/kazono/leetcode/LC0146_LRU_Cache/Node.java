package jp.co.kazono.leetcode.LC0146_LRU_Cache;

public class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}