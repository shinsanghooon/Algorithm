package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem42583 {


    public static void main(String[] args) {
        Problem42583 t = new Problem42583();

        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 5, 6};

        int solution = t.solution(bridgeLength, weight, truckWeights);
        System.out.println("return = " + solution);
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {

        LinkedList<Integer> truckQueue = new LinkedList<Integer>();
        for (int i = 0; i < truckWeights.length; i++) {
            truckQueue.add(truckWeights[i]);
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < bridgeLength; i++) {
            queue.add(0);
        }


        int seconds = 0;
        while (true) {

            if (queue.size() > bridgeLength) {
                throw new IllegalStateException("다리의 길이는 " + bridgeLength + " 보다 클 수 없습니다.");
            }

            int bridgeSum = queue.stream().mapToInt(Integer::intValue).sum();

            int nextPoll = truckQueue.peek() != null ? truckQueue.peek() : 0;
            System.out.println("nextPoll = " + nextPoll);

            if (bridgeSum + nextPoll - queue.peek() > weight) {
                seconds++;
                queue.add(0);
                queue.poll();
                System.out.println("queue = " + queue.toString());
                System.out.println("seconds = " + seconds);
                System.out.println("--------------");
                continue;
            }

            Integer poll = truckQueue.poll();
            int truckPoll = poll != null ? poll : 0;
            queue.add(truckPoll);
            queue.poll();

            System.out.println("queue = " + queue.toString());

            seconds++;
            System.out.println("seconds = " + seconds);
            System.out.println("--------------");
            int afterBridgeSum = queue.stream().mapToInt(Integer::intValue).sum();
            if (truckQueue.isEmpty() && afterBridgeSum == 0) {
                break;
            }
        }

        return seconds;
    }
}
