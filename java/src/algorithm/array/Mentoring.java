package algorithm.array;

import java.util.Scanner;

// 다시 풀어보기
public class Mentoring {

    public int solution(int n, int m, int[][] arr) {

        int answer = 0;

        // (멘토, 멘티)
        // 대략 4*4가 경우의 수이다. 같은 경우를 포함하더라도
        // (1,2) (1,3) (1,4) 이런 모든 케이스에서 다 앞서는지를 확인해봐야한다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj  = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer ++ ;
                }
            }
        }

        return answer;
    }

    // 4중 포문을 이용해서 풀어봐야한다.
    public static void main(String[] args) {
        Mentoring T = new Mentoring();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 학생수
        int m = scanner.nextInt(); // 시험 횟수
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));

    }
}
