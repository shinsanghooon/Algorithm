package algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindingCalf {

    int[] dis = {1, -1, 5};

    // 한 번 큐에 들어간 건 다시 넣지 않는다?
    // 방문한 곳은 어차피 다시 탐색해봤자 깊이만 깊어지니까 안하기 위해서
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int solution(int s, int e) {

        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;

        while (!Q.isEmpty()) {

            // 레벨 탐색을 위해
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int value = Q.poll();

                if (value == e) {
                    return L;
                }

                for (int j = 0; j < dis.length; j++) {
                    int nx = value + dis[j];

                    // 수직선 범위 + 다시 방문한 위치를 방문하지 않기 위해 
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }

//                if (value > e) {
//                    continue;
//                } else if (value < e) {
//                    for (int di : dis) {
//                        Q.offer(di + value);
//                    }
//                } else {
//                    return L++;
//                }
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        FindingCalf T = new FindingCalf();

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.solution(s, e));

    }
}
