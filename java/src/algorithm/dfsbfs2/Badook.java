package algorithm.dfsbfs2;

import java.util.Scanner;

public class Badook {

    static int answer = Integer.MIN_VALUE;
    static int n, total = 0;
    static int c = 0;

    public void DFS(int L, int sum, int[] arr) {

        if (sum > c) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        Badook T = new Badook();

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
