package programmers.problem42628;

import java.util.PriorityQueue;

public class Problem42628 {

    private static class DoublyPriorityQueue {
        private int size = 0;

        private final PriorityQueue<Integer> minQ = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);

        public void add(int value) {
            minQ.add(value);
            maxQ.add(value);
            size++;
        }

        public void removeMax() {
            if (size == 0) {
                return;
            }
            maxQ.poll();
            if (--size == 0) {
                maxQ.clear();
                minQ.clear();
            }

            System.out.println("size = " + size);
            System.out.println("maxQ.size() = " + maxQ.size());
            System.out.println("minQ.size() = " + minQ.size());
            System.out.println("-------------------");

        }

        public void removeMin() {
            if (size == 0) {
                return;
            }
            minQ.poll();
            if (--size == 0) {
                maxQ.clear();
                minQ.clear();
            }

            System.out.println("size = " + size);
            System.out.println("maxQ.size() = " + maxQ.size());
            System.out.println("minQ.size() = " + minQ.size());
            System.out.println("-------------------");
        }

        public int max() {
            if (size == 0) {
                return 0;
            }
            return maxQ.peek();
        }

        public int min() {
            if (size == 0) {
                return 0;
            }
            return minQ.peek();
        }
    }

    public static void main(String[] args) {
        Problem42628 t = new Problem42628();

//        String[] operations = {
//            "I 16",
//            "I -5643",
//            "D -1",
//            "D 1",
//            "D 1",
//            "I 123",
//            "D -1"
//        };

        String[] operations = {
            "I -45",
            "I 653",
            "D 1",
            "I -642",
            "I 45",
            "I 97",
            "D 1",
            "D -1",
            "I 333"
        };

        int[] result = t.solution(operations);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(String[] operations) {

        DoublyPriorityQueue dpq = new DoublyPriorityQueue();
        for (String operation : operations) {
            String[] split = operation.split(" ");

            String operationType = split[0];
            int number = Integer.parseInt(split[1]);

            if (operationType.equals("I")) {
                dpq.add(number);
            } else if (operationType.equals("D")) {
                if (number == 1) {
                    dpq.removeMax();
                } else {
                    dpq.removeMin();
                }
            }
        }

        return new int[]{dpq.max(), dpq.min()};
    }
}
