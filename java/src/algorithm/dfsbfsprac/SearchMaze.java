package algorithm.dfsbfsprac;

public class SearchMaze {

    public static int[][] maze;
    public static int n;

    // 상(0), 좌(1), 하(2), 우(3)
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static int[][] ch;

    public static int answer = 0;
    public static void main(String[] args) {
        SearchMaze t = new SearchMaze();

        maze = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
        };
//        maze = new int[][]{
//                {0, 0, 0},
//                {0, 1, 1},
//                {0, 0, 0},
//        };

        n = maze.length;

        ch = new int[n][n];

        t.solution();
        System.out.println("answer = " + answer);
    }

    private int solution() {
        return DFS(0, 0, 0);
    }

    private int DFS(int x, int y, int prevDirection) {

        if (x == n - 1 && y == n - 1) {
            return answer++;
        } else {
            for (int direction = 0; direction < dx.length; direction++) {

                if (x != 0 || y != 0) {
                    int diff = Math.abs(prevDirection - direction);
                    if (diff == 2) {
                        continue;
                    }
                }

                int new_x = x + dx[direction];
                int new_y = y + dy[direction];


                // 방문 여부를 여기에 체크를 해줘야한다!
                // 나머지는 비슷하게 잘함
                if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < n && maze[new_y][new_x]==0) {
                    maze[new_y][new_x] = 1;
                    DFS(new_x, new_y, direction);
                    maze[new_y][new_x] = 0;
                }
            }
        }
        return 0;
    }
}
