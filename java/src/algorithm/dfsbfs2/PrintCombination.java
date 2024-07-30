package algorithm.dfsbfs2;

public class PrintCombination {

    public static int n, m;
    public static int[] p;
    public static void main(String[] args) {

        PrintCombination t = new PrintCombination();

        n = 4;
        m = 3;

        p = new int[m];

        t.solution(n, m);

    }

    private void solution(int n, int m) {

        DFS(0, 0);
    }

    private void DFS(int L, int value) {

        if (L == m) {
            for (int i : p) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            if (L == 0) {
                // 첫번째 가지
                for (int i = 1; i <= n; i++) {
                    p[L] = i;
                    DFS(L + 1, i);
                }
            } else {
                // 두번째 가지부터, 본인보다 큰 값에 대해서만 순회한다.
                for (int i = value + 1; i <= n; i++) {
                    p[L] = i;
                    DFS(L + 1, i);
                }
            }
        }
    }
}
