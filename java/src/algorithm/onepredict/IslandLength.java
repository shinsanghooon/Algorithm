package algorithm.onepredict;

import java.util.ArrayList;
import java.util.List;

public class IslandLength {

    static int n, m, islandCount;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public class Point {
        int x ;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        IslandLength t = new IslandLength();

        int[][] maps = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,1},
                {1,1,1,1}
        };
        n = maps.length;
        m = maps[0].length;

        int solution = t.solution(maps);
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] maps) {
        List<List<Point>> islandMaps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1) {
                    ArrayList<Point> tmp = new ArrayList<>();
                    tmp.add(new Point(i, j));
                    islandCount++;
                    maps[i][j] = 0;
                    DFS(i, j, maps, tmp);
                    islandMaps.add(tmp);
                }
            }
        }

        if (islandCount == 0) {
            return 0;
        }

        int maxBorderLength = Integer.MIN_VALUE;
        for (List<Point> islandMap : islandMaps) {
            int[][] tmpMaps = new int[n][m];
            for (Point point : islandMap) {
                tmpMaps[point.x][point.y] = 1;
            }
            int length = calculateTotalBorderLength(tmpMaps);
            System.out.println("length = " + length);

            maxBorderLength = Math.max(maxBorderLength, length);
        }

        return maxBorderLength;
    }


    private void DFS(int x, int y, int[][] maps, List<Point> tmp) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                maps[nx][ny] = 0;
                tmp.add(new Point(nx, ny));
                DFS(nx, ny, maps, tmp);
            }
        }
    }


    private int calculateTotalBorderLength(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        int totalBorderLength = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (maps[row][col] == 1) {
                    int cellBorderLength = 0;
                    if (row == 0 || maps[row - 1][col] == 0) {
                        cellBorderLength++;
                    }
                    if (col == 0 || maps[row][col - 1] == 0) {
                        cellBorderLength++;
                    }
                    if (row == rows - 1 || maps[row + 1][col] == 0) {
                        cellBorderLength++;
                    }
                    if (col == cols - 1 || maps[row][col + 1] == 0) {
                        cellBorderLength++;
                    }
                    totalBorderLength += cellBorderLength;
                }
            }
        }
        return totalBorderLength;
    }
}
