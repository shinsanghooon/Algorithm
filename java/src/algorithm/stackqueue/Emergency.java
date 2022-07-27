package algorithm.stackqueue;

import java.util.*;

public class Emergency {

    private int solution(int n, int m, int[] arr) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(arr[i]);
        }

        while (true) {
            int peek = queue.peek();
            int max = Collections.max(queue);
            if (peek < max) {
                queue.offer(queue.poll());
                if (m != 0) {
                    m--;
                } else {
                    m = queue.size() - 1;
                }
            } else {
                queue.poll();
                answer++;
                if (m == 0) {
                    break;
                }
                m--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Emergency T = new Emergency();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
