package algorithm.dfsbfs;

public class CombinationMemo {

    int[][] dy = new int[35][35];
    public static void main(String[] args) {

        CombinationMemo t = new CombinationMemo();

        int n = 33;
        int r = 19;

        t.solution(n, r);
    }

    private void solution(int n, int r) {
        int dfs = DFS(n, r);
        System.out.println("dfs = " + dfs);
    }

    private int DFS(int n, int r) {

        // 값이 채워졌으면 값 그대로 리턴.
        // 메모이제이션
        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

}
