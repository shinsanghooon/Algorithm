package algorithm.dfsbfs2;

import java.util.Scanner;

public class MaxScore {

    static int answer = Integer.MIN_VALUE, n, m;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {

        if (time > m) {
            return;
        }

        if (L == n) {
            // 끝에 도달했을 때
            answer = Math.max(sum, answer);
        } else {
            // 트리를 더 만든다
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        MaxScore T = new MaxScore();
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);

    }
}
