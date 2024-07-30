package programmers.problem70129;

import java.util.Scanner;

public class Problem70129 {

    public int[] solution(String s) {

        int countZero = 0;
        int loops = 0;

        while (!s.equals("1")) {
            System.out.println("loops = " + loops);
            int countOnes = 0;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '0') {
                    countZero++;
                } else {
                    countOnes++;
                }
            }
            loops++;
            s = Integer.toString(countOnes, 2);
        }

        return new int[]{loops, countZero};
    }

    public static void main(String[] args) {

        Problem70129 T = new Problem70129();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] solution = T.solution(s);
        System.out.println("solution[0] = " + solution[0]);
        System.out.println("solution[0] = " + solution[1]);
    }

}
