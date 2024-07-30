package algorithm.dfsbfs;

import algorithm.dfsbfs2.MaxScore;

public class MaxScoreLimitMiniute {

    public static final int n = 5;
    public static final int limit = 20;

    public int[] ch = new int[n];

    public static int totalScore = Integer.MIN_VALUE;

    static class Problem {

        int score;
        int minutes;

        public Problem(int score, int minutes) {
            this.score = score;
            this.minutes = minutes;


    }

    public static void main(String[] args) {
        MaxScoreLimitMiniute t = new MaxScoreLimitMiniute();


        Problem[] problems = {
            new Problem(10, 5),
            new Problem(25, 12),
            new Problem(15, 8),
            new Problem(6, 3),
            new Problem(7, 4),
        };

        t.solution(problems);
        System.out.println("totalScore = " + totalScore);
    }

}

    private void solution(Problem[] problems) {

        DFS(0, 0, 0, problems);

    }

    private void DFS(int i, int score, int totalMinutes, Problem[] problems) {

        if (totalMinutes > limit) {
            return;
        }

        // 항상 업데이트 할 필요 없고 I==n 일 때만 찾으면 됨
        if (totalScore < score) {
            totalScore = score;
        }

        if (i == n) {
            return;
        } else {
            DFS(i + 1, score + problems[i].score, totalMinutes + problems[i].minutes, problems);
            DFS(i + 1, score, totalMinutes, problems);
        }


    }

    }
