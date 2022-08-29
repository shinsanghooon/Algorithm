package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TimeState implements Comparable<TimeState> {

    public int time;
    public char state;

    TimeState(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(TimeState t) {
        if (this.time == t.time) {
            return this.state - t.state;
        } else {
            return this.time - t.time;
        }
    }
}


public class Wedding {

    public int solution(int n, ArrayList<TimeState> arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        Collections.sort(arr);

        for (TimeState timeState : arr) {
            if (timeState.state == 's') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt > answer) {
                answer = cnt;
            }
        }

        return  answer;
    }

    public static void main(String[] args) {
        Wedding T = new Wedding();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<TimeState> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new TimeState(s, 's'));
            arr.add(new TimeState(e, 'e'));
        }

        System.out.println(T.solution(n, arr));
    }
}
