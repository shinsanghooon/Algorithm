package algorithm.dfsbfs;

public class ShortestPathFromRootToLeaf {

    Node root;

    public int DFS(int L, Node root) {

        if (root.lt == null && root.rt == null) {
            // 말단 노드이면
            return L;
        } else {
            // 작은 값을 리턴
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }

    public static void main(String[] args) {

        ShortestPathFromRootToLeaf tree = new ShortestPathFromRootToLeaf();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.lt.lt.lt = new Node(6);
        tree.root.lt.lt.rt = new Node(7);

        System.out.println(tree.DFS(0, tree.root));



    }
}
