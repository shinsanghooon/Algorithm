package algorithm.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class NaughtyChild {

    private ArrayList<Integer> solution(int n, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length -1 ; i++) {

            if (arr[i] > arr[i + 1]) {
                if (answer.size() == 0) {
                    answer.add(i + 1);
                } else {
                    answer.add(i + 2);
                }
            }
        }

        if (answer.size() == 1) {
            int after = answer.get(0);
            for (int i = 0; i < answer.get(0) - 1; i++) {
                if (arr[answer.get(0) - 1] == arr[i]) {
                    answer.remove(0);
                    answer.add(i + 1);
                    answer.add(after + 1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        NaughtyChild T = new NaughtyChild();
        ArrayList<Integer> solution = T.solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
