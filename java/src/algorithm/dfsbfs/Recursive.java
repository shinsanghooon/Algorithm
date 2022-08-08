package algorithm.dfsbfs;

import java.util.Scanner;

public class Recursive {

    public void DFS(int n) {

        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Recursive T = new Recursive();

        Scanner scanner = new Scanner(System.in);
        T.DFS(scanner.nextInt());
    }
}
