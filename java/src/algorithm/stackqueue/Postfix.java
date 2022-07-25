package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    private int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '+' ) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int tmp = num2 + num1;
                stack.push(tmp);
            } else if(x == '-') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int tmp = num2 - num1;
                stack.push(tmp);
            } else if (x == '*') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int tmp = num2 * num1;
                stack.push(tmp);
            } else if (x == '/') {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int tmp = num2 / num1;
                stack.push(tmp);
            }
             else {
                stack.push(Character.getNumericValue(x));
            }
        }

        return stack.pop();
    }

    public int solution2(String str) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.get(0);
        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Postfix T = new Postfix();
        String str = scanner.next();

        System.out.println(T.solution2(str));

    }
}
