package jp.co.kazono.leetcode.LC0145_Binary_Tree_Postorder_Traversal;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree.
        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(2);
        TreeNode node_2 = new TreeNode(3);
        root.right = node_1;
        node_1.left = node_2;

        List<Integer> res = s.postorderTraversal(root);
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(res.toArray(new Integer[res.size()]))));
    }
}
