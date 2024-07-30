package programmers.problem42892;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem42892 {

    private static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Problem42892 t = new Problem42892();

        int[][] nodeInfo = {
            {5, 3},
            {11, 5},
            {13, 3},
            {3, 5},
            {6, 1},
            {1, 3},
            {8, 6},
            {7, 2},
            {2, 2}
        };

        int[][] result = t.solution(nodeInfo);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    private int[][] solution(int[][] nodeInfo) {

        Node[] nodes = new Node[nodeInfo.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }

        // y를 기준으로 정렬
        // 제일 처음 나오는 노드가 루트가 된다.
        Arrays.sort(nodes, (a, b) -> b.y - a.y);

        Node root = constructTree(nodes);

        ArrayList<Integer> preOrder = new ArrayList<>();
        pre(root, preOrder);

        ArrayList<Integer> postOrder = new ArrayList<>();
        post(root, postOrder);

        return new int[][]{
            preOrder.stream().mapToInt(Integer::intValue).toArray(),
            postOrder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private void post(Node node, ArrayList<Integer> visits) {
        if (node == null) {
            return;
        }

        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);

    }

    private void pre(Node node, ArrayList<Integer> visits) {
        if (node == null) {
            return;
        }

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);

    }

    private Node constructTree(Node[] nodes) {

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    private void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
}
