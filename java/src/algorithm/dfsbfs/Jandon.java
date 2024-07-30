package algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;


class CoinSum {

    public int coinSum;

    public int L;

    public CoinSum(int coinSum, int l) {
        this.coinSum = coinSum;
        L = l;
    }
}

public class Jandon {

//    public static int n = 3;
//    public static int target =15;
//    public static int[] coins = {1, 2, 5};

//    public static int n = 12;
//    public static int target = 290;
//    public static int[] coins = {1,5,10,15,20,25,30,50,70,65,90,100};

    public static int n = 11;
    public static int target = 390;
    public static int[] coins = {1,5,10,15,20,25,30,50,70,65,90};


    public static void main(String[] args) {
        Jandon t = new Jandon();

        int solution = t.solution();
        System.out.println("solution = " + solution);
    }

    private int solution() {

        Queue<CoinSum> q = new LinkedList<>();
        q.offer(new CoinSum(0, 0));

        while (!q.isEmpty()) {

            CoinSum poll = q.poll();
            if (poll.coinSum == target) {
                return poll.L ;
            }

            for (int i = 0; i < n; i++) {
                q.offer(new CoinSum(poll.coinSum + coins[i], poll.L+1));
            }

        }

        return 0;
    }

}
