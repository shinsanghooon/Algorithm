package programmers;

import java.util.Arrays;

public class Problem43105 {

    private static int callCnt = 0;

    private final int[][] mem = new int[501][501];

    public static void main(String[] args) {
        Problem43105 t = new Problem43105();

        int[][] triangle = new int[][]{
            {7},
            {3,8},
            {8,1,0},
            {2,7,4,4},
            {4,5,2,6,5}
        };
        int answer = t.solution(triangle);
        System.out.println("answer = " + answer);
        System.out.println("callCnt = " + callCnt);
    }

    private int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return max(0, 0, triangle);
    }

    private int max(int x , int y, int[][] triangle) {
        callCnt++;
        // 종료 조건
        if (y == triangle.length) {
            return 0;
        }

        if (mem[x][y] != -1) {
            return mem[x][y];
        }

        return mem[x][y] = triangle[y][x] + Math.max(
            // 다음 줄 검색
            max(x, y + 1, triangle),
            max(x + 1, y + 1, triangle));
    }

}
