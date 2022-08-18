package algorithm.dfsbfs2;

import java.util.Scanner;

public class DuplicatePermutation {

    static int n, m;
    static  int[] pm;


    public void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= 3; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];

        DuplicatePermutation T = new DuplicatePermutation();
        T.DFS(0);

    }

}
