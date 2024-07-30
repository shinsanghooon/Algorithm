package algorithm.dfsbfs2;

public class IslandCount {

    static int n;

    static int[][] board, dis;

    static int answer = 0;


    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        IslandCount t = new IslandCount();

        n = 7;

        dis = new int[7][7];

        board = new int[][]{
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
        };

        t.solution();
        System.out.println(answer);
    }

    private void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(board[i][j]);
                    System.out.println("-------");
                    DFS(i, j);
                    answer += 1;
                }
            }
        }

    }

    private void DFS(int x, int y) {
        if (board[x][y] == 1) {
            for (int k = 0; k < dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    board[x][y] = 0;
                    DFS(nx, ny);
                }
            }
        }
    }
}
