package algorithm.programmerskit;

import java.util.ArrayList;
import java.util.Collections;

public class Pccp2Cafe {

    static class Order implements Comparable<Order> {

        int seconds;
        char state;

        public Order(int seconds, char state) {
            this.seconds = seconds;
            this.state = state;
        }

        @Override
        public int compareTo(Order o) {
            if (this.seconds == o.seconds) {
                return this.state - o.state;
            }
            return this.seconds - o.seconds;
        }
    }

    public static void main(String[] args) {
        Pccp2Cafe t = new Pccp2Cafe();

        int[] menu = {5, 12, 30};
        int[] order = {2, 1, 0, 0, 0, 1, 0};
        int k = 10;

        int result = t.solution(menu, order, k);

        System.out.println("result = " + result);
    }

    private int solution(int[] menu, int[] order, int k) {

        ArrayList<Order> orders = new ArrayList<>();

        int orderEnd = 0;
        for (int i = 0; i < order.length; i++) {
            int enterSeconds = k * i;

            int orderStart = Math.max(enterSeconds, orderEnd);
            orderEnd = orderStart + menu[order[i]]; //12
            int waitStart = Math.min(enterSeconds, orderStart);

            orders.add(new Order(waitStart, 's'));
            orders.add(new Order(orderEnd, 'e'));
        }

        Collections.sort(orders);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Order o : orders) {
            if (o.state == 's') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
