package algorithm.programmerskit;

public class Network {
    static int n = 3;

    static int count = 0;

    static int[] isVisited = new int[n];

    static int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
    };
    public static void main(String[] args) {

        Network t = new Network();
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == 1) {
                continue;
            }
            t.DFS(0); // DFS 하나가 정상적으로 끝나면 1을 카운트 하는 것이다.
            count++;
        }
        System.out.println("count = " + count);
    }

    private void DFS(int L) {
        if (L == computers.length) {
            return;
        } else {
            int[] computer = computers[L];
            isVisited[L] = 1;

            for (int i = 0; i < computer.length; i++) {
                if (computer[i] == 1 && isVisited[i] == 0) {
                    DFS(L + 1);
                }
            }
        }
    }
}
