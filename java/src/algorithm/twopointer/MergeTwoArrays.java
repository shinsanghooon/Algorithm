package algorithm.twopointer;

import java.util.ArrayList;

public class MergeTwoArrays {

    public static void main(String[] args) {
        MergeTwoArrays t = new MergeTwoArrays();

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 6, 8, 9};

        ArrayList<Integer> solution = t.solution(arr1, arr2);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }

    private ArrayList<Integer> solution(int[] arr1, int[] arr2) {

        ArrayList<Integer> answers = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {
            int a = arr1[p1];
            int b = arr2[p2];

            if (a > b) {
                answers.add(b);
                p2++;
            } else if (a == b) {
                answers.add(a);
                answers.add(b);
                p1++;
                p2++;
            } else {
                answers.add(a);
                p1++;
            }
        }

        if (p1 < arr1.length) {
            for (int i = p1; i < arr1.length; i++) {
                answers.add(arr1[i]);
            }
        }

        if (p2 < arr2.length) {
            for (int i = p2; i < arr2.length; i++) {
                answers.add(arr2[i]);
            }
        }

        return answers;
    }
}
