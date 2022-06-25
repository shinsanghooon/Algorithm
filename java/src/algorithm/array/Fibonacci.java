package algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {

    public int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }

    }
}
