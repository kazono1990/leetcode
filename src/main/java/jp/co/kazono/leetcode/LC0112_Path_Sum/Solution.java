package jp.co.kazono.leetcode.LC0112_Path_Sum;

public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        TreeNode root = new TreeNode(5);
        TreeNode node_1 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(8);
        root.left = node_1;
        root.right = node_2;

        TreeNode node_3 = new TreeNode(11);
        TreeNode node_4 = new TreeNode(13);
        TreeNode node_5 = new TreeNode(4);
        node_1.left = node_3;
        node_2.left = node_4;
        node_2.right = node_5;

        TreeNode node_6 = new TreeNode(7);
        TreeNode node_7 = new TreeNode(2);
        TreeNode node_8 = new TreeNode(1);
        node_3.left = node_6;
        node_3.right = node_7;
        node_5.right = node_8;

        System.out.println(s.hasPathSum(root, 22));
    }
}
