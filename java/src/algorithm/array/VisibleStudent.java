package algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class VisibleStudent {
    public int solution(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer += 1;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        VisibleStudent T = new VisibleStudent();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, arr));

//        8
//        130 135 148 140 145 150 150 153
        // 이중 포문으로 풀지 말자 n이 최대 100,000 이다.
    }
}
