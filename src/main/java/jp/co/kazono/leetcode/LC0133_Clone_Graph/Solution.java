package jp.co.kazono.leetcode.LC0133_Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    // {key, value} = {original clone, clone node}
    private HashMap<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return nodeMap.get(node);
    }

    private List<Node> init(int[][] adjList) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            nodeList.add(new Node(i + 1));
        }
        for (int i = 0; i < adjList.length; i++) {
            List<Node> neighbors = new ArrayList<>();
            for (int id : adjList[i]) {
                neighbors.add(nodeList.get(id - 1));
            }
            nodeList.get(i).neighbors = neighbors;
        }
        return nodeList;
    }

    private void printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("NodeId: " + node.val).append("\n");
        sb.append("Neighbor: [ ");
        for (Node neighbor : node.neighbors) {
            sb.append(neighbor.val + " ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Node> nodeList = s.init(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Node clone = s.cloneGraph(nodeList.get(0));
        s.printNode(nodeList.get(0));
        s.printNode(clone);
        System.out.println(nodeList.get(0) == clone);
    }
}
