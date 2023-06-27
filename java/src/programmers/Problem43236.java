package programmers;

import java.util.Arrays;

public class Problem43236 {


    public static void main(String[] args) {
        Problem43236 t = new Problem43236();
        int distance = 25;
        int[] rocks = {2, 14, 11 ,21, 17};
        int n = 2;

        int result = t.solution(distance, rocks, n);
        System.out.println("result = " + result);
    }

    private int solution(int distance, int[] rocks, int n) {

        rocks = Arrays.copyOf(rocks, rocks.length +1 );
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int start = 1;
        int end = distance + 1;

        while (end - start > 1) {
            int d = (start + end) / 2;

            if (isValid(d, rocks, n)) {
                start = d;
            } else {
                end = d;
            }
        }

        return start;
    }

    private boolean isValid(int d, int[] rocks, int n) {
        int removed = 0;
        int last = 0;
        for (int rock : rocks) {
            System.out.println("d: " + d + " n: " + n + " rock: " + rock + " last: " + last + " (rock-last): " + (rock - last) + " removed: " + removed);
            if (rock - last < d) {
                removed++;
                continue;
            }

            last = rock;
        }
        return removed <= n;

    }

}
