package jp.co.kazono.leetcode.LC0110_Balanced_Binary_Tree;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root, 0) >= 0;
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) return depth;
        int leftTreeDepth = helper(node.left, depth + 1);
        int rightTreeDepth = helper(node.right, depth + 1);
        if (leftTreeDepth < 0 || rightTreeDepth < 0 || Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
            return -1;
        }
        return Math.max(leftTreeDepth, rightTreeDepth);
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

        System.out.println(s.isBalanced(root));
    }
}
