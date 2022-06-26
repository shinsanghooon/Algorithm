package algorithm.array;

import java.util.Scanner;

public class GetGrade {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        // 이중 포문이 되는가?
        // 이중 포문을 사용한다.
        for (int i = 0; i < n; i++) {
            int order = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    order++;
                }
            }
            answer[i] = order;
        }

        return answer;
    }

    public static void main(String[] args) {
        GetGrade T = new GetGrade();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] solution = T.solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
