package algorithm.programmerskit;

import java.util.Arrays;

public class IntTriangle {

    static int[][] mem = new int[500][500];

    static int[][] triangle = new int[][]{
            {7},
            {3,8},
            {8,1,0},
            {2,7,4,4},
            {4,5,2,6,5}
    };

    public static void main(String[] args) {
        IntTriangle t = new IntTriangle();

        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }

        int solution = t.solution(0, 0);
        System.out.println("solution = " + solution);

    }

    private int solution(int x, int y) {

        if (y == triangle.length) {
            return 0;
        }

        if (mem[x][y] != -1) {
            return mem[x][y];
        }

        return mem[x][y] = triangle[y][x] + Math.max(
                solution(x, y + 1),
                solution(x + 1, y + 1)
        );

    }
}
