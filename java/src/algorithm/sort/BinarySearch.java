package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class BinarySearch {


    private int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if (arr[mid] > m) {
                rt = mid -1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearch T = new BinarySearch();

        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
        }

        System.out.println(T.solution(n, m, arr));

//        8 32
//        23 87 65 12 57 32 99 81
    }
}
