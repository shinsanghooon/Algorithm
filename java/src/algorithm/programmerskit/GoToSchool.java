package algorithm.programmerskit;

public class GoToSchool {
    public static void main(String[] args) {

        GoToSchool t = new GoToSchool();

        int m = 4;
        int n = 3;
        int[][] arr = new int[m][n];

        int[][] puddles = {{2, 2}};

        int[][] isPuddle = new int[m][n];

        for (int i = 0; i < puddles.length; i++) {
            int p1 = puddles[i][0];
            int p2 = puddles[i][1];
            isPuddle[p1 - 1][p2 - 1] = 1;
        }

    }

}
