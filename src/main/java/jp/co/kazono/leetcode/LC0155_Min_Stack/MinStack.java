package jp.co.kazono.leetcode.LC0155_Min_Stack;

public class MinStack {

    private Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            Node node = new Node(val, Math.min(val, head.min), head);
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
