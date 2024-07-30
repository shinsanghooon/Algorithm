package algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CommonElement {

    private ArrayList<Integer> solution(int[] arr1, int[] arr2) {

        ArrayList<Integer> answers = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {
            int a = arr1[p1];
            int b = arr2[p2];

            if (a < b) {
                p1++;
            } else if (a == b) {
                answers.add(a);
                p1++;
                p2++;
            } else {
                p2++;
            }
        }

        return answers;
    }
    public static void main(String[] args) {
        CommonElement t = new CommonElement();

        int[] arr1 = {1, 3, 9, 5, 2};
        int[] arr2 = {2, 5, 7, 8, 9};

        ArrayList<Integer> solution = t.solution(arr1, arr2);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }


    }
}

