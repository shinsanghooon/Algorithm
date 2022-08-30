package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


class Lecture implements Comparable<Lecture>{
    public int revenue;
    public int time;

    Lecture(int revenue, int time) {
        this.revenue = revenue;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture t) {
        return t.time - this.time;
    }
}

// PQ를 사용한다.
public class MaxRevenueSchedule {

    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        // poll()을 하면 제일 작은 순서를 먼저 주는데 reverseOrder를 사용하면 제일 큰 값을 준다
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i) {
                    break;
                }
                pQ.offer(arr.get(j).revenue);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        MaxRevenueSchedule T = new MaxRevenueSchedule();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if (d > max) {
                max = d;
            }
        }

        System.out.println(T.solution(arr));
    }
}
