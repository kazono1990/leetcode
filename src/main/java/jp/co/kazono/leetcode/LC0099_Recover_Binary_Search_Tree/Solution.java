package jp.co.kazono.leetcode.LC0099_Recover_Binary_Search_Tree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null; // first node need to swap.
        TreeNode second = null; // second node need to swap.
        TreeNode prev = new TreeNode(Integer.MIN_VALUE); // previous node.

        TreeNode[] stack = new TreeNode[1000]; // stack for TreeNode.
        int top = 0;
        
        while (root != null || top > 0) {
            while (root != null) {
                stack[top] = root;
                root = root.left;
                top++;
            }

            root = stack[--top];
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        root.left = node_3;
        node_3.right = node_2;
        s.recoverTree(root);
    }
}
