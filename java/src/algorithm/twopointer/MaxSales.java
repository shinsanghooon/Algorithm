package algorithm.twopointer;

import java.util.Scanner;

public class MaxSales {

    // 이렇게 해도 결국 이중포문이 되는 것이다 n^2
    private int solution(int n, int k, int[] arr) {
        int answer = 0;

        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }

        for (int i = 0; i < n - k; i++) {
            int tmpSales = 0;
            for (int j = i; j < i + k; j++) {
                tmpSales += arr[j];
            }
            if (answer < tmpSales) {
                answer = tmpSales;
            }
        }
        return answer;
    }

    private int solution2(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;

        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    // 시간 제한 걸림
    public static void main(String[] args) {
        MaxSales T = new MaxSales();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution2(n, k, arr));
    }
}
