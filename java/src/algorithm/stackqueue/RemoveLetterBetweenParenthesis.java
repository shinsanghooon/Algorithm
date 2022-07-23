package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveLetterBetweenParenthesis {

    private String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<Character>();

        for (char x : str.toCharArray()) {
            if (x != ')') {
                stack.push(x);
            } else {
                // 닫는 괄호이면
                while (stack.pop() != '(') ;
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RemoveLetterBetweenParenthesis T = new RemoveLetterBetweenParenthesis();
        String str = scanner.next();

        System.out.println(T.solution(str));

    }
}
