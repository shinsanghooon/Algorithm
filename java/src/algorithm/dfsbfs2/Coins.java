package algorithm.dfsbfs2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coins {

    static int n, exchanges;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] coins) {


        if (sum > exchanges) {
            return;
        }

        if (L >= answer) {
            return;
        }

        if (sum == exchanges) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + coins[i], coins);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());

        exchanges = sc.nextInt();

        Coins T = new Coins();
        T.DFS(0, 0, coins);
        System.out.println(answer);

    }
}
