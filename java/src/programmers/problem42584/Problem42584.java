package programmers.problem42584;

import java.util.Stack;

public class Problem42584 {

    public static void main(String[] args) {
        Problem42584 t = new Problem42584();

        int[] prices = new int[]{1, 2, 3, 2, 3};

        int[] solution = t.solution(prices);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);

            System.out.println("stack.toString() = " + stack.toString());
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }

}
