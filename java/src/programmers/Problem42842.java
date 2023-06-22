package programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem42842 {


    private int brownSize(int width, int height) {
        return (width * 2) + (height - 2) * 2;
    }

    private int yellowSize(int width, int height) {
        return (width - 2 ) * (height - 2);
    }
    public int[] solution(int brown, int yellow) {

//        width, height 최솟값은 3
        for (int width = 3; width < 2500; width++) {
            for (int height = 3; height <= width; height++) {
                if (brownSize(width, height) == brown && yellowSize(width, height) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Problem42842 T = new Problem42842();

        Scanner sc = new Scanner(System.in);

        int brown = sc.nextInt();
        int yellow = sc.nextInt();

        int[] solution = T.solution(brown, yellow);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
