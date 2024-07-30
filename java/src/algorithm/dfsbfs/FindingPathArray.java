package algorithm.dfsbfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FindingPathArray {
    static int[] ch; // 체크 배열

    // 어레이 리스트를 저장하는 어레이 리스트
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m, answer = 0;

    public void DFS(int v) {

        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        // N이 매우 커질 경우 인접행렬을 사용하기가 어려워진다.
        // n = 10,000 인 경우, 배열은 100,000,000이 된다.
        FindingPathArray T = new FindingPathArray();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);


    }


}
