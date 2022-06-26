package algorithm.array;

import java.util.Scanner;

public class CrossBoardMaxSum {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        // 가로, 세로
        int colMaxSum = 0;
        int rowMaxSum = 0;
        for (int i = 0; i < n; i++) {
            int tmpColSum = 0;
            int tmpRowSum = 0;
            for (int j = 0; j < n; j++) {
                tmpColSum += arr[i][j];
                tmpRowSum += arr[j][i];
            }
            if (tmpColSum > colMaxSum) {
                colMaxSum = tmpColSum;
            }
            if (tmpRowSum > rowMaxSum) {
                rowMaxSum = tmpRowSum;
            }
        }

        int maxStraightSum = 0;
        if (colMaxSum > rowMaxSum) {
            maxStraightSum = colMaxSum;
        } else {
            maxStraightSum = rowMaxSum;
        }

        // 대각선
        int rightToLeftMaxSum = 0;
        int leftToRightMaxSum = 0;
        for (int i = 0; i < n; i++) {
            rightToLeftMaxSum += arr[i][i];
            leftToRightMaxSum += arr[i][n - i - 1];
        }

        int maxDiagSum = 0;
        if (rightToLeftMaxSum > leftToRightMaxSum) {
            maxDiagSum = rightToLeftMaxSum;
        } else {
            maxDiagSum = leftToRightMaxSum;
        }

        if (maxStraightSum > maxDiagSum) {
            answer = maxStraightSum;
        } else {
            answer = maxDiagSum;
        }

        return answer;
    }

    public int solution2(int n, int[][] arr) {
        // 전력이 뭐가 있을까
        // 행의합, 열의합 따로 구한다
        int answer = Integer.MIN_VALUE;
        int sum1;
        int sum2;
        for (int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(sum1, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        CrossBoardMaxSum T = new CrossBoardMaxSum();
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
