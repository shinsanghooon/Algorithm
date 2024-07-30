package algorithm.programmerskit;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MockExam {

    public static int[] USER1_BASE = {1, 2, 3, 4, 5};
    public static int[] USER2_BASE = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] USER3_BASE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int[] results = new int[3];
    public static void main(String[] args) {

        int[] answers = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        MockExam t = new MockExam();

        int[] solution = t.solution(answers2);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(int[] answers) {

        for (int i = 0; i < answers.length; i++) {
            int user1_answer = USER1_BASE[(i) % USER1_BASE.length];
            int user2_answer = USER2_BASE[(i) % USER2_BASE.length];
            int user3_answer = USER3_BASE[(i) % USER3_BASE.length];
            int answer = answers[i];

            if (user1_answer == answer) {
                results[0]++;
            }
            if (user2_answer == answer) {
                results[1]++;
            }
            if (user3_answer == answer) {
                results[2]++;
            }
        }

        int max = Arrays.stream(results).max().orElse(Integer.MIN_VALUE);

        return IntStream.range(0, 3)
                .filter(i -> results[i] == max)
                .map(i -> i + 1)
                .toArray();

    }
}
