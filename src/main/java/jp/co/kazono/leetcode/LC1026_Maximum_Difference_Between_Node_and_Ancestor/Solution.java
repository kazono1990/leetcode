package jp.co.kazono.leetcode.LC1026_Maximum_Difference_Between_Node_and_Ancestor;

public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int curMax, int curMin) {
        // if node is leaf, return curMax - curMin.
        if (node == null) {
            return curMax - curMin;
        }

        // update curMax and curMin
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        TreeNode root = new TreeNode(8);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_10 = new TreeNode(10);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_14 = new TreeNode(14);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_13 = new TreeNode(13);

        root.left = node_3;
        root.right = node_10;
        node_3.left = node_1;
        node_3.right = node_6;
        node_10.right = node_14;
        node_6.left = node_4;
        node_6.right = node_7;
        node_14.left = node_13;

        System.out.println(s.maxAncestorDiff(root));
    }
}
