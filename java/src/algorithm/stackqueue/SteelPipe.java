package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class SteelPipe {


    private int solution(String str) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    // laser;
                    answer += stack.size();
                } else {
                    // 막대기의 끝
                    answer ++;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        SteelPipe T = new SteelPipe();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        // ()(((()())(())()))(())
        System.out.println(T.solution(str));

    }
}
