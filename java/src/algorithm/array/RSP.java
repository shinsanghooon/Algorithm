package algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class RSP {
    public ArrayList<String> solution(int n, int[] arrA, int[] arrB) {

        // 1 -> A
        // -2 -> A
        // 2 -> B
        // -1 -> B
        // 0 -> D

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int result = arrA[i] - arrB[i];
            if (result == 1 || result == -2) {
                answer.add("A");
            } else if (result == -1 || result == 2) {
                answer.add("B");
            } else if (result == 0){
                answer.add("D");
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        RSP T = new RSP();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arrB[i] = scanner.nextInt();
        }

        ArrayList<String> solution = T.solution(n, arrA, arrB);
        for (String s : solution) {
            System.out.println(s);
        }

    }
}
