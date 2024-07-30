package algorithm.programmerskit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapMinimumDistance {

    public class Point{

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static int[] directionsX = {0, 0, -1, 1}; // 상 하 좌 우
    public static int[] directionsY = {1, -1, 0, 0}; // 상 하 좌 우
    public static void main(String[] args) {
        MapMinimumDistance t = new MapMinimumDistance();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        int result = t.solution(maps2);
        System.out.println("result = " + result);

    }

    private int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        int[][] distanceMap = new int[n][m];
        for (int i = 0; i < distanceMap.length; i++) {
            Arrays.fill(distanceMap[i], -1);
        }

        Queue<Point> q = new LinkedList<>();

        Point initialPoint = new Point(0, 0);
        q.add(initialPoint);

        distanceMap[0][0] = 1;
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == n && point.y == m) {
                System.out.println(point.x);
                System.out.println(point.y);
                break;
            }

            // 상하좌우
            for (int i = 0; i < directionsX.length; i++) {
                int nx = point.x + directionsX[i];
                int ny = point.y + directionsY[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (isRoad(ny, maps[nx])) {
                        maps[nx][ny] = 0;
                        distanceMap[nx][ny] = distanceMap[point.x][point.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
        return distanceMap[n - 1][m - 1];
    }

    private static boolean isRoad(int ny, int[] maps) {
        return maps[ny] == 1;
    }
}
