package algorithm.twopointer;

import java.util.Scanner;

public class PartialSequence {

    private int solution(int n, int m, int arr[]) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer ++;
            }

            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer ++;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        PartialSequence T = new PartialSequence();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }

}
