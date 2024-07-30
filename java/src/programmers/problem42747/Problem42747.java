package programmers.problem42747;

import java.util.Arrays;

public class Problem42747 {


    public int solution(int[] arr) {

        int answer = 0;

        Arrays.sort(arr);

        int maxCitations = arr[arr.length - 1];

        for (int h = maxCitations; h > 0; h--) {
            int criteria = h;
            long countOverH = Arrays.stream(arr).filter(e -> e >= criteria)
                .count();

            if (countOverH < criteria) {
                continue;
            }

            answer = Math.max(answer, criteria);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem42747 s = new Problem42747();

        int[] arr = new int[]{3, 0, 6, 1, 5};

        int result = s.solution(arr);
        System.out.println("result = " + result);
    }

}
