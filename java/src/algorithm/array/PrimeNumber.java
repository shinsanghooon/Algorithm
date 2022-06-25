package algorithm.array;

import java.util.Scanner;

public class PrimeNumber {


    public int solution(int n) {
         int answer = 0;

        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    // 한 번 더 보기
    public static void main(String[] args) {
        PrimeNumber T = new PrimeNumber();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
    }
}
