package jp.co.kazono.leetcode.LC0662_Maximum_Width_of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    private int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(3);
        root.left = node_1;
        node_1.left = new TreeNode(5);
        node_1.right = new TreeNode(3);
        System.out.println(s.widthOfBinaryTree(root));

    }
}
