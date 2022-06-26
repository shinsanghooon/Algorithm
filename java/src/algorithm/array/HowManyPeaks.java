package algorithm.array;

import java.util.Scanner;

public class HowManyPeaks {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        int[][] tmpArr = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                tmpArr[i][j] = arr[i-1][j-1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if ((tmpArr[i][j] > tmpArr[i - 1][j]) && (tmpArr[i][j] > tmpArr[i + 1][j]) && (tmpArr[i][j] > tmpArr[i][j + 1]) && (tmpArr[i][j] > tmpArr[i][j - 1])) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution2(int n, int[][] arr) {
        int answer = 0;

        // 미리 방향을 만들어 놓는다.
        // 대각선까지 8개의 방향을 보는 케이스도 있다.

        // 이까지만 하면 Boundary 에외가 발생한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx > 0 && nx <n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HowManyPeaks T = new HowManyPeaks();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(T.solution2(n, arr));

    }
}
