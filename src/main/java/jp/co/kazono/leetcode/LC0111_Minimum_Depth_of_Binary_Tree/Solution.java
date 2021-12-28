package jp.co.kazono.leetcode.LC0111_Minimum_Depth_of_Binary_Tree;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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

        System.out.println(s.minDepth(root));
    }
}
