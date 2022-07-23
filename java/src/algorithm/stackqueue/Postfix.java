package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    private int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        int tmp = 0;
        for (char x : str.toCharArray()) {
            if (x == '+' ) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                tmp = num2 + num1;
                stack.push(tmp);
            } else if(x == '-') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                tmp = num2 - num1;
                stack.push(tmp);
            } else if (x == '*') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                tmp = num2 * num1;
                stack.push(tmp);
            } else if (x == '/') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                tmp = num2 / num1;
                stack.push(tmp);
            }
             else {
                stack.push(Character.getNumericValue(x));
            }
        }

        return tmp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Postfix T = new Postfix();
        String str = scanner.next();


        System.out.println(T.solution(str));

    }
}
