package algorithm.dp;

import java.util.Scanner;

public class StoneBridge {

    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }


    public static void main(String[] args) {

        StoneBridge T = new StoneBridge();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m+1;

        dy = new int[ n + 1];
        System.out.println(T.solution(n));

    }
}
