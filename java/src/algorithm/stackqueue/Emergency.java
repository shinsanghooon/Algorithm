package algorithm.stackqueue;

import java.util.Scanner;

public class Emergency {

    private int solution(int n, int m, int[] arr) {
        int answer = 1;

        int target = arr[m];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= target) {
                if (arr[i] == target) {
                    if (i < m) {
                        answer ++;
                    }
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Emergency T = new Emergency();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
