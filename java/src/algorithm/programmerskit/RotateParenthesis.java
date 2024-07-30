package algorithm.programmerskit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateParenthesis {

    public static void main(String[] args) {
        RotateParenthesis t = new RotateParenthesis();

        String s = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        int result = t.solution(s3);
        System.out.println("result = " + result);
    }

    private int solution(String s) {
        char[] chars = s.toCharArray();

        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : chars) {
            queue.add(c);
        }

        for (int i = 0; i < chars.length; i++) {

            if (isCorrect(queue)) {
                System.out.print(i + " ");
                System.out.println("correct");
                count++;
            }

            Character peek = queue.poll();
            queue.add(peek);
        }
        return count;
    }

    private boolean isCorrect(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        for (char c : queue) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else  {
                Character peek = stack.peek();

                if (c == ']') {
                    if (peek != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (peek != '{') {
                        return false;
                    }
                } else if (c == ')') {
                    if (peek != '(') {
                        return false;
                    }
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
