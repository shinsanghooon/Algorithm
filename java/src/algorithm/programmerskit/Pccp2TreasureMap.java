package algorithm.programmerskit;

import java.util.LinkedList;
import java.util.Queue;

public class Pccp2TreasureMap {

    static class Point {
        int x ;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] directions_x = {0, 1}; // 상, 우
    static int[] directions_y = {1, 0}; // 상, 우
    public static void main(String[] args) {
        Pccp2TreasureMap t = new Pccp2TreasureMap();

        int n = 4;
        int m = 4;
        int[][] hole = {
                {2, 3},
                {3, 3}
        };

        int result = t.solution(n, m, hole);
        System.out.println("result = " + result);

    }

    public int solution(int n, int m, int[][] hole) {

        // 2칸을 뛸 수 있는 신발이 있음
        //  1. 일단 원래대로 최단거리를 구한다.
        //  2. hole을 만난 경우에 신발을 사용한다.
        //  3. 나머지 경우는 그냥 계산하고 마지막에 나온 값에서 1을 빼준다.

        return BFS(n, m, hole);
    }

    private int BFS(int n, int m, int[][] hole) {
        int[][] map = new int[n][m];

        int[][] holeMap = new int[n][m];
        for (int i = 0; i < hole.length; i++) {
            holeMap[hole[i][0] - 1][hole[i][1] - 1] = 1;
        }
        boolean useMagic = false;

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0));
        while (!q.isEmpty()) {

            Point poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 2; i++) {
                int nx = x + directions_x[i];
                int ny = y + directions_y[i];

                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("nx = " + nx);
                System.out.println("ny = " + ny);

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (holeMap[nx][ny] == 1) {

                        System.out.println("meet hole");

                        if (useMagic == false) {
                            System.out.println("use shoes!");
                            nx = nx + directions_x[i];
                            ny = ny + directions_y[i];
                            System.out.println("jump nx = " + nx);
                            System.out.println("jump ny = " + ny);

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && holeMap[nx][ny] == 0) {
                                System.out.println("jump success");
                                q.add(new Point(nx, ny));
                                if (nx == n - 1 && ny == m - 1) {
                                    if (map[nx][ny] != 0) {
                                        map[nx][ny] = Math.min(map[nx][ny], map[nx][ny] + 1);
                                    } else {
                                        map[nx][ny] = map[x][y] + 1;
                                    }
                                } else {
                                    map[nx][ny] = map[x][y] + 1;
                                }
                                useMagic = true;
                            } else {
                                System.out.println("jump fail");
                            }
                        }
                    } else {
                        q.add(new Point(nx, ny));
                        if (nx == n - 1 && ny == m - 1) {
                            if (map[nx][ny] != 0) {
                                map[nx][ny] = Math.min(map[nx][ny], map[nx][ny] + 1);
                            } else {
                                map[nx][ny] = map[x][y] + 1;
                            }
                        } else {
                            map[nx][ny] = map[x][y] + 1;
                        }

                        System.out.println("map[x][y] = " + map[x][y]);
                        System.out.println("map[nx][ny] = " + map[nx][ny]);
                    }
                }

                System.out.println("---");

            }
        }

        int answer = map[n - 1][m - 1];
        if (answer == 0) {
            return -1;
        }
        return answer;

    }
}
