package algorithm.programmerskit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class MakeBigNumber {
    public static void main(String[] args) {
        MakeBigNumber t = new MakeBigNumber();

        String number = "4177252841";
        int k = 4;


        String result = t.solution(number , k);
        System.out.println("result = " + result);

    }
    public String solution(String number, int k) {

        char[] chars = number.toCharArray();

        Stack<Character> q = new Stack<>();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {

            if (count == k) {
                q.add(chars[i]);
                continue;
            }

            if (i == 0) {
                q.add(chars[i]);
                continue;
            }

            Character last = q.peek();
            int lastNumber = Integer.parseInt(String.valueOf(last));
            int currentNumber = Integer.parseInt(String.valueOf(chars[i]));

            System.out.println("---");
            while (lastNumber < currentNumber) {
                System.out.println("lastNumber = " + lastNumber);
                System.out.println("currentNumber = " + currentNumber);
                Character pop = q.pop();
                System.out.println("pop = " + pop);
                count++;
                lastNumber = Integer.parseInt(String.valueOf(q.peek()));


            }
            q.add(chars[i]);

        }

        return q.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

    }
}
