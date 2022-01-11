package jp.co.kazono.leetcode.LC1022_Sum_of_Root_To_Leaf_Binary_Numbers;

public class Solution {

    private int rootToLeaf = 0;

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    private void preorder(TreeNode node, int currentNumber) {
        if (node != null) {
            currentNumber = currentNumber << 1 | node.val;
            // if node is leaf
            if (node.left == null && node.right == null) {
                rootToLeaf += currentNumber;
            }
            preorder(node.left, currentNumber);
            preorder(node.right, currentNumber);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(1);
        root.left = node_1;
        root.right = node_2;
        TreeNode node_3 = new TreeNode(0);
        TreeNode node_4 = new TreeNode(1);
        node_1.left = node_3;
        node_1.right = node_4;
        TreeNode node_5 = new TreeNode(0);
        TreeNode node_6 = new TreeNode(1);
        node_2.left = node_5;
        node_2.right = node_6;

        // 22
        System.out.println(s.sumRootToLeaf(root));
    }
}
