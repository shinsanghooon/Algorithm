package programmers.problem42883;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem42883 {

    public static void main(String[] args) {
        Problem42883 t = new Problem42883();

        String number = "4177252841";
        int k = 4;

//        String number = "1924";
//        int k = 2;

//        String number = "1231234";
//        int k= 3;

        String result = t.solution2(number, k);
        System.out.println("result = " + result);

    }

    public String solution2(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {

            // 제거할 문자 수가 남았으며
            // stack에 원소가 남아 있으며
            // 다음 숫자가 지금 스택에 있는 숫자보다 크면
            // 현재 스택에 있는 숫자를 날린다.
            while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k-- > 0) {
            stack.pop();
        }

        return stack.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    private String solution(String number, int k) {

        char[] numberToArr = number.toCharArray();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (char c : numberToArr) {
            numbers.add(Integer.parseInt(String.valueOf(c)));
        }

        int removeCount = 0;
        while (removeCount != k) {

            for (int i = 0; i < numbers.size() - 1; i++) {
                int first = numbers.get(i);
                int second = numbers.get(i + 1);

                if (first < second) {
                    numbers.remove(i);
                    removeCount++;
                    break;
                }
            }
        }

        return numbers.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }

}
