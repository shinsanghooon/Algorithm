package algorithm.array;

import java.util.Scanner;

public class CalculateScore {
    public int solution(int n, int[] arr) {
        int answer = 0;

        int currentScore = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                currentScore++;
                answer += currentScore;
            } else {
                currentScore = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CalculateScore T = new CalculateScore();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, arr));

    }
}
