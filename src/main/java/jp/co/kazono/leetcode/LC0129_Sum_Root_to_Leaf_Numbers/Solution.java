package jp.co.kazono.leetcode.LC0129_Sum_Root_to_Leaf_Numbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) return 0;
        if (node.right == null && node.left == null) return sum * 10 + node.val;
        return helper(node.left, sum * 10 + node.val) + helper(node.right, sum * 10 + node.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree.
        TreeNode root = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        root.left = node_2;
        root.right = node_3;

        System.out.println(s.sumNumbers(root));
    }
}
