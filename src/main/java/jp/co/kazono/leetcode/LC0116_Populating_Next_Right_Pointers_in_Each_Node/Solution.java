package jp.co.kazono.leetcode.LC0116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int nodeNum = nodes.size();
            for (int i = 0; i < nodeNum; i++) {
                Node cur = nodes.poll();
                if (i == nodeNum - 1) {
                    cur.next = null;
                } else {
                    cur.next = nodes.peek();
                }
                if (cur.left != null) nodes.add(cur.left);
                if (cur.right != null) nodes.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        Node root = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        Node node_7 = new Node(7);
        root.left = node_2;
        root.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;

        Node populatingNode = s.connect(root);
    }
}
