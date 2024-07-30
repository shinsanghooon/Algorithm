package programmers.problem42898;

import java.util.Arrays;

public class Problem42898 {

    private final int[][] mem = new int[101][101];

    public static void main(String[] args) {
        Problem42898 t = new Problem42898();

        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{
            {1, 2}
        };

        int result = t.solution(m, n, puddles);
        System.out.println("result = " + result);

    }

    public int solution(int m, int n, int[][] puddles) {
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }

        return count(1, 1, m, n, isPuddle);
    }

    private int count(int x, int y, int w, int h, boolean[][] isPuddle) {

        System.out.println("w = " + w + " / h = " + h);
        System.out.println("x = " + x + " / y = " + y);
        System.out.println("---------------------------------");

        if (x > w || y > h) {
            return 0;
        }

        if (isPuddle[y][x]) {
            return 0;
        }

        if (mem[x][y] != -1) {
            return mem[x][y];
        }

        if (x == w && y == h) {
            return 1;
        }

        int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);

        return mem[x][y] = total % 1000000007;

    }
}
