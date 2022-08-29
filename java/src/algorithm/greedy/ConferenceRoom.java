package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Time implements Comparable<Time> {
    public int s, e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time time) {
        if (this.e == time.e) {
            return this.s - time.s;
        } else {
            return this.e - time.e;
        }
    }
}


public class ConferenceRoom {

    public int solution(int n, ArrayList<Time> arr) {

        int cnt = 0;

        Collections.sort(arr);

        int et = 0;
        for (Time ob : arr) {
            if (ob.s >= et) {
                cnt++;
                et = ob.e;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        ConferenceRoom T = new ConferenceRoom();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }

        System.out.println(T.solution(n, arr));
    }
}
