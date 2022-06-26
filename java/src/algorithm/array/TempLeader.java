package algorithm.array;

import java.util.*;

// 다시 풀어보기
public class TempLeader {
    public int solution(int n, int[][] arr) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        int[] answerArr = new int[n];
        for (int i = 0; i < n; i++) { // i번 학생에 대해
            int cnt = 0;
            for (int j = 0; j < n; j++) { // j 학생 (비교 대상)
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i+1;
            }
        }
        return answer;
    }

    public int solutionWithRunTimeError(int n, int[][] arr) {

        int answer = 0;

        int[] tmpLeaderArr = new int[n];
        for (int i = 0; i < n; i++) { // 학생수 만큼
            HashSet<Integer> setCount = new HashSet<>();
            int[] tmp = new int[n];
            for (int k = 0; k < 5; k++) { // 5학년 만큼
                int baseClass = arr[i][k]; // i번 학생의 k학년 반
                for (int j = 0; j < n; j++) { // 학생수 만큼
                    if (i != j) {
                        if (baseClass == arr[j][k]) {
                            setCount.add(j);
                            tmp[j] = 1;
                        }
                    }
                }
            }
            tmpLeaderArr[i] = setCount.size();

        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (tmpLeaderArr[i] > maxValue) {
                answer = i + 1;
                maxValue = tmpLeaderArr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TempLeader T = new TempLeader();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));

    }
}
