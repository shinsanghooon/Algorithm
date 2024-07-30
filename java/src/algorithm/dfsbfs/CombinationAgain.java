package algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


class Combi implements Comparable<Combi> {
    public int first;
    public int second;

    public Combi(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(Combi c) {
        if (this.first == c.first) {
            return this.second - c.second;
        } else {
            return this.first - c.first;
        }
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}

public class CombinationAgain {

    public static int n;

    public static int m;

    static  int[] pm;


    public static void main(String[] args) {
        CombinationAgain t = new CombinationAgain();

        n = 3;
        m = 2;
        pm = new int[m];

        t.solution();

    }

    private void solution() {

        Queue queue = new LinkedList<Integer>();

        DFS(0);

    }

    private void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i ;
                DFS(L + 1);
            }
        }

    }
}
