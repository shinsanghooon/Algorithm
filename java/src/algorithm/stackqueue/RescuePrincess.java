package algorithm.stackqueue;

import java.util.*;

public class RescuePrincess {

    private int solution(int n, int k) {
        int answer = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        int cnt = 0;
        while (!(deque.size() == 1)) {

            cnt++;
            if (cnt == k) {
                deque.removeFirst();
                cnt = 1;
            }

            deque.add(deque.removeFirst());

        }

        return answer;
    }

    public int solution2(int n, int k) {
        int answer = 0;

        Queue<Object> Q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();

            if (Q.size()==1) {
                answer = (int) Q.poll();
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        RescuePrincess T = new RescuePrincess();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(T.solution2(n, k));
    }
}
