package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem42841 {

    public static int[] first = {1, 2, 3, 4, 5};
    public static int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] array) {

        int correctOne = 0;
        int correctTwo = 0;
        int correctThree = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first[i % first.length]) {
                correctOne ++;
            }

            if (array[i] == second[i % second.length]) {
                correctTwo ++;
            }

            if (array[i] == third[i % third.length]) {
                correctThree ++;
            }
        }

        System.out.println("correctOne = " + correctOne);
        System.out.println("correctTwo = " + correctTwo);
        System.out.println("correctThree = " + correctThree);

        int[] corrects = {correctOne, correctTwo, correctThree};
        // 3개에 대한 맥스값 비교는 어케하지?
        // 일단 max 값을 찾고
        int maxValue = Arrays.stream(corrects).max().getAsInt();

        int[] ints = IntStream.range(1,4).filter(f -> corrects[f-1] == maxValue).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

        return ints;
    }
    public static void main(String[] args) {
        Problem42841 T = new Problem42841();

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] solution = T.solution(arr);
        System.out.println("solution[0] = " + solution[0]);
    }
}
