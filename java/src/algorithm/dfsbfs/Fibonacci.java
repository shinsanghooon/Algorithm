package algorithm.dfsbfs;

import java.util.Scanner;

public class Fibonacci {

    static int[] fibo;

    public int DFS(int n) {

        // 기존에 계산한 값을 그대로 사용한다! 메모이제이션
        // 아래 코드가 없으면 오래 걸림
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {

            return fibo[n] = DFS(n - 1) + DFS(n - 2);
        }

    }

    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();

        // n이 클 때(50)는 스택 프레임이 많이 쌓인다.
        // 이럴 때는 엄청 오래 걸린다. -> 메모이제이션! 중간 중간 기록을 저장해두자.
        int n = 45;
        fibo = new int[n + 1]; // 각 숫자에 맞는 인덱스를 사용하기 위해

        long startTime = System.currentTimeMillis();
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i]);
        }

        System.out.print("time elapsed: ");
        System.out.println((System.currentTimeMillis() - startTime)/1000);
    }
}
