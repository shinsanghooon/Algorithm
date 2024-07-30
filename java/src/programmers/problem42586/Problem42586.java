package programmers.problem42586;

import java.util.LinkedList;

public class Problem42586 {

    public static void main(String[] args) {
        Problem42586 t = new Problem42586();

        int[] progresses = {93, 30, 55};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 30, 5};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] solution = t.solution(progresses, speeds);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(int[] progresses, int[] speeds) {

        LinkedList<Integer> answer = new LinkedList<>();
        LinkedList<Integer> queue = calculateExpectedCompleteDays(progresses, speeds);

        int criteria = queue.poll(); // 7
        int cnt = 1;
        System.out.println("criteria = " + criteria);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.println("next = " + next);

            if (next <= criteria) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                criteria = next;
            }

            if (queue.isEmpty()) {
                answer.add(cnt);
            }

            System.out.println("cnt = " + cnt);
            System.out.println("---------------");
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private LinkedList<Integer> calculateExpectedCompleteDays(int[] progresses, int[] speeds) {

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double ceil = Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add((int) ceil);
        }

        return queue;
    }


}
