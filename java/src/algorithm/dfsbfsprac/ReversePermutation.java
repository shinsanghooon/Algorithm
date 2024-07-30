package algorithm.dfsbfsprac;

import java.util.ArrayList;

public class ReversePermutation {

    public static int n, f = 0;

    public static int[] b;
    public static int[] p;
    public static int[] ch;

    int[][] dy = new int[10][10];

    public boolean flag = false;

    public static void main(String[] args) {

        ReversePermutation t = new ReversePermutation();

        n = 4;
        f = 16;

        b = new int[n];
        p = new int[n];
        ch = new int[n+1];

        for (int i = 0; i < n; i++) {
            b[i] = t.combi(n-1, i);
        }
        for (int i : b) {
            System.out.println("i = " + i);
        }

        t.DFS(0, 0);
    }

    private void DFS(int L, int sum) {

        if (flag == true) {
            return;
        }


        if (L == n) {
            if (sum == f) {
                for (int i : p) {
                    System.out.print(i + " ");
                }
                System.out.println();
                flag=true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + b[L] * p[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    private int combi(int n, int r) {

        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return combi(n - 1, r) + combi(n - 1, r - 1);
        }
    }
}
