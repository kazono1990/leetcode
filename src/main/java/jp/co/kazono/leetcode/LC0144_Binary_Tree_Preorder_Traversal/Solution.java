package jp.co.kazono.leetcode.LC0144_Binary_Tree_Preorder_Traversal;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        helper(node.left, res);
        helper(node.right, res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree.
        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(2);
        TreeNode node_2 = new TreeNode(3);
        root.right = node_1;
        node_1.left = node_2;

        List<Integer> res = s.preorderTraversal(root);
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(res.toArray(new Integer[res.size()]))));
    }
}
