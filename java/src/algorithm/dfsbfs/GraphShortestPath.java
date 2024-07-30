package algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphShortestPath {

    static int[] ch; // 체크 배열
    static int[] dis;

    // 어레이 리스트를 저장하는 어레이 리스트
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m, answer = 0;
    public void BFS(int v) {

        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;

        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();

            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);

                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        GraphShortestPath T = new GraphShortestPath();

        n = 6;
        m = 9;
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[][] inputs = new int[][]{
            {1, 3},
            {1, 4},
            {2, 1},
            {2, 5},
            {3, 4},
            {4, 5},
            {4, 6},
            {6, 2},
            {6, 5}
        };


        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = inputs[i][0];
            int b = inputs[i][1];
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.BFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }




    }

}
