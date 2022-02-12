package jp.co.kazono.leetcode.LC0155_Min_Stack;

public class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
