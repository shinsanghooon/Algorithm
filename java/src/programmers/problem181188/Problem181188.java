package programmers.problem181188;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Missile implements Comparable<Missile> {
    public int s, e;

    Missile(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String toString() {
        return "{" + s + ", " + e + '}';
    }

    @Override
    public int compareTo(Missile missile) {
        if (this.s == missile.s) {
            return missile.e - this.e;
        } else {
            return this.s - missile.s;
        }
    }
}
public class Problem181188 {

    public static void main(String[] args) {
        Problem181188 t = new Problem181188();

        int[][] target = {
                {4, 5},
                {4, 8},
                {10, 14},
                {11, 13},
                {5, 12},
                {3, 7},
                {1, 4}
        };

        int answer = t.solution2(target);
        System.out.println("answer = " + answer);
    }


    public int solution2(int[][] targets) {
        Arrays.sort(targets, (o1, o2)-> o1[1] - o2[1]);

        for (int[] target : targets) {
            for (int i : target) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int cur = 0;
        int answer = 0;
        for(int i = 0; i < targets.length; i++){
            System.out.println("cur = " + cur);
            System.out.println("targets[i][0] = " + targets[i][0]);
            if(cur > targets[i][0]) continue;
            cur = targets[i][1];
            answer++;
            System.out.println("----");
        }
        return answer;
    }

    public int solution(int[][] target) {
        ArrayList<Missile> arr = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            Missile missile = new Missile(target[i][0], target[i][1]);
            arr.add(missile);
        }

        Collections.sort(arr);

        int answer = 0;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int[] success = new int[target.length];

        for (int i = 0; i < target.length; i++) {
            int sum = dfs(i, arr, success, start, end, true);
            System.out.println("sum = " + sum);
            answer += sum;
            System.out.println("answer = " + answer);

            System.out.println("------------");
        }

        return answer;

    }

    private int dfs(int i, ArrayList<Missile> arr, int[] success, int start, int end, boolean newGroup) {

        System.out.println("i = " + i);

        if (i == arr.size() - 1 && !newGroup) {
            success[i] = 1;
            return 1;
        }

        if (success[i] != 0) {
            return 0;
        }

        Missile missile = arr.get(i);

        if (newGroup) {
            start = missile.s;
            end = missile.e;
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        Missile nextMissile = arr.get(i + 1);
        int next_start = nextMissile.s;
        int next_end = nextMissile.e;

        // 미사일이 동일한 범위에 해당이 안되면 리턴
        if (next_start <= start && next_end <= start) {
            success[i] = 1;
            return 1;
        }

        if (next_start >= end && next_end >= end) {
            success[i] = 1;
            return 1;
        }

        // 범위 줄이기
        if (start <= next_start) {
            start = next_start;
        }

        if (end >= next_end) {
            end = next_end;
        }

        success[i] = 1;

        return dfs(i + 1, arr, success, start, end, false);

    }
}
