package algorithm.dfsbfs2;

import java.util.LinkedList;

public class Pizza {

    public static int n, m;
    public static int[][] board;

    public static LinkedList<Integer> answers = new LinkedList<>();

    public static int[][] visited;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        Pizza t = new Pizza();

        n = 4;
        m = 4;

        visited = new int[n][n];

        board = new int[][]{
                {0, 1, 2, 0},
                {1, 0, 2, 1},
                {0, 2, 1, 2},
                {2, 0, 1, 2}
        };

        t.solution();

        for (Integer answer : answers) {
            System.out.println("answer = " + answer);
        }
    }

    public void solution() {
        int pizzaCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    answers.add(0);
                    DFS(i, j, i, j, pizzaCount);
                    pizzaCount++;
                    visited = new int[n][n];
                    System.out.println("-----");
                }
            }
        }
    }

    private void DFS(int x, int y, int pizzaX, int pizzaY, int pizzaCount) {
        int distance = 0;
        visited[x][y] = 1;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && nx < n && ny >= 0 && ny < n ) {
                if (visited[nx][ny] == 1) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    System.out.println("pizzaX = " + pizzaX + " / pizzaY = " + pizzaY);
                    System.out.println("nx = " + nx + " / ny = " + ny);
                    distance = Math.abs(pizzaX - nx) + Math.abs(pizzaY - ny);
                    System.out.println("distance = " + distance);
                    System.out.println("answers.get(pizzaCount) = " + answers.get(pizzaCount));

                    Integer old = answers.get(pizzaCount) == null ? 0 : answers.get(pizzaCount);
                    answers.set(pizzaCount, old + distance);
                    System.out.println("answers.size() = " + answers.size());

                    System.out.println("---");
                }

                visited[nx][ny] = 1;

                DFS(nx, ny, pizzaX, pizzaY, pizzaCount);
            }



        }
    }


}
