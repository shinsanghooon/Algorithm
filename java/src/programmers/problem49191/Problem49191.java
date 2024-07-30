package programmers.problem49191;

public class Problem49191 {

    public static void main(String[] args) {
        Problem49191 t = new Problem49191();

        int n = 5;
        int[][] results = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}
        };

        int solution = t.solution(n, results);

        System.out.println("solution = " + solution);

    }

    private int solution(int n, int[][] results) {

        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        int count = 0;
        for (int u = 0; u < n; u++) {
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int losses = countBackward(u, graph, new boolean[n]) - 1;
            if (wins + losses + 1 == n) {
                count++;
            }
        }

        return count;
    }

    private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph.length; v++) {
            if(!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }
        return count;
    }

    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if(!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }

        return count;
    }
}
