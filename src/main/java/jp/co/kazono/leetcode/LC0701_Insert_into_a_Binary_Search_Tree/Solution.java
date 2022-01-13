package jp.co.kazono.leetcode.LC0701_Insert_into_a_Binary_Search_Tree;

public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (curr.val < val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

         // init binary tree
        TreeNode root = new TreeNode(4);
        TreeNode node_1 = new TreeNode(2);
        TreeNode node_2 = new TreeNode(7);
        root.left = node_1;
        root.right = node_2;
        TreeNode node_3 = new TreeNode(1);
        TreeNode node_4 = new TreeNode(3);
        node_1.left = node_3;
        node_1.right = node_4;

        s.insertIntoBST(root, 5);
    }
}
