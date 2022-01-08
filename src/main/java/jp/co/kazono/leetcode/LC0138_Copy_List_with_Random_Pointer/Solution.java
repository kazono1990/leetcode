package jp.co.kazono.leetcode.LC0138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node node = head;
        Map<Node, Node> nMap = new HashMap<>();
        // copy all nodes.
        while (node != null) {
            nMap.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            nMap.get(node).next = nMap.get(node.next);
            nMap.get(node).random = nMap.get(node.random);
            node = node.next;
        }
        return nMap.get(head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init Random List
        Node head = new Node(7);
        Node node_1 = new Node(13);
        Node node_2 = new Node(11);
        Node node_3 = new Node(10);
        Node node_4 = new Node(1);
        head.next = node_1;
        head.random = null;
        node_1.next = node_2;
        node_1.random = head;
        node_2.next = node_3;
        node_2.random = node_4;
        node_3.next = node_4;
        node_3.random = node_2;
        node_4.next = null;
        node_4.random = head;

        Node copy = s.copyRandomList(head);
    }
}
