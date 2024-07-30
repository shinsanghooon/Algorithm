package algorithm.programmerskit;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Pccp2NewBie {

    public static void main(String[] args) {

        Pccp2NewBie t = new Pccp2NewBie();

        int[] ability = {1, 2, 3, 4};
        int number = 3;

        int result = t.solution(ability, number);
        System.out.println("result = " + result);
    }


    public int solution(int[] ability, int number) {

        PriorityQueue<Integer> pq = Arrays.stream(ability)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a + b);
            pq.add(a + b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }

    private int edu(int[] ability, int number, int count) {

        Arrays.sort(ability);

        int first = ability[0];
        int second = ability[1];
        int sumAbility = first + second;
        ability[0] = sumAbility;
        ability[1] = sumAbility;

        count++;
        if (count == number) {
            int sum = Arrays.stream(ability)
                    .sum();
            return sum;
        } else {
            return edu(ability, number, count);
        }
    }
}
