package algorithm.programmerskit;

public class Pccp1AthleticCompetition {

//    public static int[][] scores = {
//            {40, 10, 10},
//            {20, 5, 0},
//            {30, 30, 30},
//            {70, 0, 70},
//            {100, 100, 100}
//    };

    public static int[][] scores = {
            {20, 30},
            {30, 20},
            {20, 30},
    };



    public static int maxScore = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Pccp1AthleticCompetition t = new Pccp1AthleticCompetition();

        t.solution(scores);
        System.out.println("maxScore = " + maxScore);

    }

    public int solution(int[][] ability) {
        int[] isVisited = new int[ability.length];
        DFS(0, 0, isVisited, ability);
        return maxScore;
    }

    public void DFS(int L, int score, int[] isVisited, int[][] scores) {
        if (L == scores[0].length) {
            maxScore = Math.max(score, maxScore);
        } else {
            for (int i = 0; i < scores.length; i++) {
                if (isVisited[i] != 1) {
                    isVisited[i] = 1;
                    DFS(L + 1, score + scores[i][L], isVisited, scores);
                    isVisited[i] = 0;
                }
            }
        }
    }
}
