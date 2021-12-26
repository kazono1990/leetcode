package jp.co.kazono.leetcode.LC0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.Stack;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // boundary case.
        if (inorder.length == 0 || postorder.length == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        // get root node and push to stack.
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);

        // i is index in postorder[], and j is index in inorder[].
        int i = postorder.length - 2;
        int j = inorder.length - 1;

        while (i >= 0) {
            // get a top tree node in stack. (not remove it)
            TreeNode curr = stack.peek();
            if (curr.val != inorder[j]) {
                // as long as we have not reach the rightmost node we can safely follow right path and attach right child.
                TreeNode right = new TreeNode(postorder[i]);
                curr.right = right;
                stack.push(right);
                i--;
            } else {
                // found the node from stack where we have not visited its left subtree.
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    curr = stack.pop();
                    j--;
                }
                TreeNode left = new TreeNode(postorder[i]);
                curr.left = left;
                stack.push(left);
                i--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = s.buildTree(inorder, postorder);
    }
}
