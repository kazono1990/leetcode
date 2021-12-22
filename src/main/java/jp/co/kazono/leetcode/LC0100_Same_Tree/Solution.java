package jp.co.kazono.leetcode.LC0100_Same_Tree;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode p = new TreeNode(1);
        TreeNode p_2 = new TreeNode(2);
        TreeNode p_3 = new TreeNode(3);
        p.left = p_2;
        p.right = p_3;

        TreeNode q = new TreeNode(1);
        TreeNode q_2 = new TreeNode(2);
        TreeNode q_3 = new TreeNode(3);
        q.left = q_2;
        q.right = q_3;

        System.out.println(s.isSameTree(p, q));
    }
}
