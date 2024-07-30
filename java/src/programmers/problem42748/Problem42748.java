package programmers.problem42748;

import java.util.Arrays;

public class Problem42748 {

    public int[] solution(int[] arr, int[][] commands) {

        int[] result = new int[commands.length];

        for (int index=0; index < commands.length; index++) {
            System.out.println("index = " + index);
            int[] command = commands[index];

            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] cutArr = Arrays.copyOfRange(arr, i - 1, j);

            Arrays.sort(cutArr);
            result[index] = cutArr[k - 1];
        }

        return result;
    }


    public static void main(String[] args) {
        Problem42748 Problem42748 = new Problem42748();

        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };

        int[] result = Problem42748.solution(arr, commands);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
