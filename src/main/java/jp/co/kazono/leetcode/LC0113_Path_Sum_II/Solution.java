package jp.co.kazono.leetcode.LC0113_Path_Sum_II;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);
        if (node.left == null && node.right == null && targetSum == node.val) {
            res.add(new ArrayList(path));
        }

        dfs(node.left, targetSum - node.val, res, path);
        dfs(node.right, targetSum - node.val, res, path);
        // remove node which already checked
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init binary tree
        TreeNode root = new TreeNode(5);
        TreeNode node_1 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(8);
        root.left = node_1;
        root.right = node_2;

        TreeNode node_3 = new TreeNode(11);
        TreeNode node_4 = new TreeNode(13);
        TreeNode node_5 = new TreeNode(4);
        node_1.left = node_3;
        node_2.left = node_4;
        node_2.right = node_5;

        TreeNode node_6 = new TreeNode(7);
        TreeNode node_7 = new TreeNode(2);
        TreeNode node_8 = new TreeNode(5);
        TreeNode node_9 = new TreeNode(1);
        node_3.left = node_6;
        node_3.right = node_7;
        node_5.left = node_8;
        node_5.right = node_9;

        List<List<Integer>> paths = s.pathSum(root, 22);
        for (List<Integer> _path : paths) {
            int[] path = ArrayUtils.toPrimitive(_path.toArray(new Integer[_path.size()]));
            System.out.println(Arrays.toString(path));
        }
    }
}
