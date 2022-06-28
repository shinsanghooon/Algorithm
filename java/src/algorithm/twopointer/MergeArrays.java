package algorithm.twopointer;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeArrays {

    public ArrayList<Integer> solution(int n, int[] arr, int b, int[] bArr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < b) {
            if (arr[p1] < bArr[p2]) {
                answer.add(arr[p1++]);
            } else {
                answer.add(bArr[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(arr[p1++]);
        }

        while (p2 < b) {
            answer.add(bArr[p2++]);
        }
        return answer;
    }

    public static void main(String[] args) {
        MergeArrays T = new MergeArrays();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
        }

        int b = scanner.nextInt();
        int[] bArr = new int[b];
        for (int i = 0; i < b; i++) {
            bArr[i] = scanner.nextInt();
        }

        for(int x : T.solution(n, arr, b, bArr)){
            System.out.print(x + " ");
        };
    }



}
