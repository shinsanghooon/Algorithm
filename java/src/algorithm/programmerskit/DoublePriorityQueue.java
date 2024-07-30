package algorithm.programmerskit;

import java.util.PriorityQueue;

public class DoublePriorityQueue {

    static class DoublePQ {

        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> a - b);

        int size = 0;

        public void insert(int n) {
            maxPq.add(n);
            minPq.add(n);
            size++;
        }
        public int getMax() {
            if (size <= 0) {
                return 0;
            }
            return maxPq.poll();
        }

        public int getMin() {
            if (size <= 0) {
                return 0;
            }
            return minPq.poll();
        }

        public void deleteMax() {
            if (size <= 0) {
                return;
            }
            maxPq.poll();
            size--;
        }

        public void deleteMin() {
            if (size <= 0) {
                return;
            }
            minPq.poll();
            size--;
        }

        public boolean isEmpty() {
            return size <= 0;
        }
    }


    public static void main(String[] args) {
        DoublePriorityQueue t = new DoublePriorityQueue();

        String[] operations = {
            "I 16",
            "I -5643",
            "D -1",
            "D 1",
            "D 1",
            "I 123",
            "D -1"
        };
//
//        String[] operations = {
//                "I -45",
//                "I 653",
//                "D 1",
//                "I -642",
//                "I 45",
//                "I 97",
//                "D 1",
//                "D -1",
//                "I 333"
//        };

        int[] result = t.solution(operations);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(String[] operations) {

        DoublePQ q = new DoublePQ();

        for (String operation : operations) {
            String[] operationArr = operation.split(" ");
            String work = operationArr[0];
            int number = Integer.parseInt(operationArr[1]);

            if (work.equals("I")) {
                q.insert(number);
            } else {
                if (number == 1) {
                    q.deleteMax();
                } else {
                    q.deleteMin();
                }
            }
        }

        if (q.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{q.getMax(), q.getMin()};
    }
}
