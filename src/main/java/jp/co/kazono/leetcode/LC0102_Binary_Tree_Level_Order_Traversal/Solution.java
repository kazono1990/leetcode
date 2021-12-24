package jp.co.kazono.leetcode.LC0102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // if root is not null, enqueue root to 'queue'
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            // get the number of node in 'queue'
            int levelSize = queue.size();
            // init List for collecting same level values
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                // dequeue the node
                TreeNode cur = queue.poll();
                // if the node has child nodes, enqueue these nodes to 'queue'
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                // add value to list
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init Binary Tree
        TreeNode root = new TreeNode(3);
        TreeNode node_1 = new TreeNode(9);
        TreeNode node_2 = new TreeNode(20);
        root.left = node_1;
        root.right = node_2;
        TreeNode node_3 = new TreeNode(15);
        TreeNode node_4 = new TreeNode(7);
        node_2.left = node_3;
        node_2.right = node_4;

        List<List<Integer>> levelOrder = s.levelOrder(root);
        System.out.print("[");
        for (List orders : levelOrder) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for (Object val : orders) {
                sb.append(val.toString() + " ");
            }
            sb.append("]");
            System.out.print(sb);
        }
        System.out.println("]");
    }
}
