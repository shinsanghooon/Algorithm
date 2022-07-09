package algorithm.twopointer;

import java.util.Scanner;

public class SumOfNumber {

    public int solution(int n) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int answer = 0;
        for (int lt = 0; lt < n - 1; lt++) {
            int sum = 0;
            int rt = lt;
            while (true) {
                sum += arr[rt++];
                if (sum == n) {
                    answer++;
                }
                if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;
        int sum = 0 ;
        int lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer ++;
            }

            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        SumOfNumber T = new SumOfNumber();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));

    }
}
