package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesis {

    private String solution(String str) {

        String answer = "YES";
        char[] chars = str.toCharArray();

        Stack<Character> stck = new Stack<>();

        for (char x : chars) {
            if (x == '(') {
                stck.push(x);
            } else {
                if (stck.isEmpty()) {
                    return "NO";
                }
                stck.pop();
            }
        }

        if (!stck.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CorrectParenthesis T = new CorrectParenthesis();
        String str = scanner.next();

        System.out.println(T.solution(str));

    }
}
