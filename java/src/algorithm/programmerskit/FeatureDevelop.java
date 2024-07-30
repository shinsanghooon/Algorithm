package algorithm.programmerskit;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FeatureDevelop {

    public static void main(String[] args) {
        FeatureDevelop t = new FeatureDevelop();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = t.solution2(progresses, speeds);
        for (int i : result) {
            System.out.println("i = " + i);
        }

    }

    private int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answers = new ArrayList<>();

        Queue<Integer> queue = createWorkDays(progresses, speeds);

        while (!queue.isEmpty()) {
            int count = 1;
            int currentWork = queue.poll();
            int nextWork = queue.peek();

            System.out.println("currentWork = " + currentWork);
            System.out.println("nextWork = " + nextWork);
            System.out.println("-----");

            while ( currentWork >= nextWork ) {
                queue.poll();
                count++;
                nextWork = queue.peek();
                System.out.println("nextWork = " + nextWork);
            }


            answers.add(count);
        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private Queue<Integer> createWorkDays(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        return queue;
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil((100.0 - progresses[index]) / speeds[index]);
            if (expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }

        result.add(count);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

}
