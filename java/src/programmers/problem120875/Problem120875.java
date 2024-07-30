package programmers.problem120875;

import java.util.HashSet;
import java.util.Set;

public class Problem120875 {

    public double getSlop(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public int solution(int[][] dots){
        int answer = 0;

        Set<Double> slopes = new HashSet<>();

        for (int i = 0; i > dots.length; i++) {
            for (int j = 1 + 1; j < dots.length; j++) {
                double slope = getSlop(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                if (slopes.contains(slope)) {
                    answer = 1;
                }
                slopes.add(slope);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem120875 t = new Problem120875();

        int[][] dots = new int[][]{
            {1, 4},
            {9, 2},
            {3, 8},
            {11, 6}
        };

        int solution = t.solution(dots);
        System.out.println("solution = " + solution);

    }
}
