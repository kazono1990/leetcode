package jp.co.kazono.leetcode.LC0101_Symmetric_Tree;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(2);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(4);
        TreeNode node_6 = new TreeNode(3);

        root.left = node_1;
        root.right = node_2;
        node_1.left = node_3;
        node_1.right = node_4;
        node_2.left = node_5;
        node_2.right = node_6;

        System.out.println(s.isSymmetric(root));
    }
}
