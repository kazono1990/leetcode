package jp.co.kazono.leetcode.LC0107_Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                level.add(curr.val);
            }
            // add new level as first element
            res.add(0, level);
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

        List<List<Integer>> levelOrder = s.levelOrderBottom(root);
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
