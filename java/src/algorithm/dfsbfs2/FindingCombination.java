package algorithm.dfsbfs2;

import java.util.Scanner;

public class FindingCombination {

    static int n, m;
    static int[] combi;

    public void DFS(int L, int s) {
        if (L == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) {
        FindingCombination T = new FindingCombination();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];
        T.DFS(0, 1);

    }
}
