package algorithm.sort;

import java.util.HashSet;
import java.util.Scanner;

public class CheckDuplicate {

    private String solution(int n, int[] arr) {
        String answer = "U";

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }

        if (arr.length != hashSet.size()) {
            answer = "D";
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

        CheckDuplicate T = new CheckDuplicate();
        System.out.println(T.solution(n, arr));

    }
}
