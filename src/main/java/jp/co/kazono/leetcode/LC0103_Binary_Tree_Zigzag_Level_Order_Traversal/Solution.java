package jp.co.kazono.leetcode.LC0103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // use flag for decide the order of add value
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                // if flag is true, add element to index 0
                if (zigzag) {
                    level.add(0, cur.val);
                }
                else {
                    level.add(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(level);
            // reverse
            zigzag = !zigzag;
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

        List<List<Integer>> levelOrder = s.zigzagLevelOrder(root);
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
