package algorithm.sort;

import java.util.Scanner;

public class BubbleSort {

    int[] solution(int n, int[] arr) {


        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


        return arr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BubbleSort T = new BubbleSort();
        int[] solution = T.solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }


    }

}
