package programmers.problem86971;

public class Problem86971 {

    public static void main(String[] args) {
        Problem86971 t = new Problem86971();

        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9},
        };

        t.solution(n, wires);
    }


    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        int[][] adjMap = new int[n][n];

        // i번째 vertex가 잘린 케이스 루프
        for (int i = 0; i < n; i++) {
            adjMap = getMapWithCutVertex(n, wires, i);

            // 1번 노드부터 시작해서 최대로 방문할 수 있는 노드 확인
            int[] isVisited = new int[n];
            dfs(0, adjMap, isVisited);

            // isVisited 값을 더해서 리턴
            int sum = 0;
            for (int visit : isVisited) {
                sum += visit;
            }

            int new_answer = Math.abs(sum - (n - sum));
            answer = Math.min(answer, new_answer);

            System.out.println("answer = " + answer);
            System.out.println("------");

        }

        return answer;
    }

    private void dfs(int i, int[][] adjMap, int[] isVisited) {
        isVisited[i] = 1;

        System.out.println("i = " + i);
        for (int i1 : isVisited) {
            System.out.print(i1 + " ");
        }

        for (int j = 0; j < adjMap[i].length; j++) {
            if (adjMap[i][j] == 1 & isVisited[j] == 0) {
                dfs(j, adjMap, isVisited);
            }
        }

    }

    private int[][] getMapWithCutVertex(int n, int[][] wires, int ignoreNumber) {
        int[][] adjMap = new int[n][n];


        // wire를 돌면서
        for (int i = 0; i < wires.length; i++) {
            if (i != ignoreNumber) {
                adjMap[wires[i][0] - 1][wires[i][1] - 1] = 1;
                adjMap[wires[i][1] - 1][wires[i][0] - 1] = 1;
            }
        }

        for (int[] ints : adjMap) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return adjMap;

    }
}
