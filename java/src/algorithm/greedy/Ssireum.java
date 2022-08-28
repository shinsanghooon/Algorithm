package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {
    public int h, w;

    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body body) {
        return body.h - this.h;
    }
}


public class Ssireum {

    public int solution(int n , ArrayList<Body> arr) {

        int cnt = 0;

        Collections.sort(arr);

        int max = Integer.MIN_VALUE;

        for (Body body : arr) {
            if (body.w > max) {
                max = body.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 이중 포문을 돌면 타임 리밋
        Ssireum T = new Ssireum();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<Body>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.solution(n, arr));
    }
}
