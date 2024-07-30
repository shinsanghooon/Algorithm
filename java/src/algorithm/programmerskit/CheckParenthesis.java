package algorithm.programmerskit;

import java.util.LinkedList;
import java.util.Stack;

public class CheckParenthesis {

    public static void main(String[] args) {

        CheckParenthesis t = new CheckParenthesis();

        String s1 = "(())()";
        String s2 = "()())";
        String s3 = ")()()";
        String s4 = "(()(";

        boolean solution = t.solution(s2);
        System.out.println("solution = " + solution);
    }

    private boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
