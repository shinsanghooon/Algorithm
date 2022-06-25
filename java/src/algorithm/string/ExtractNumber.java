package algorithm.string;

import java.util.Scanner;

public class ExtractNumber {

    public int solution(String str) {

        char[] chars = str.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                stringBuffer.append(c);
            }
        }
        return Integer.parseInt(stringBuffer.toString());
    }

    public int solution2(String str) {

        char[] chars = str.toCharArray();
        int answer = 0;
        for (char c : chars) {
            if (c>=48 && c<=57) { // 숫자이면
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExtractNumber T = new ExtractNumber();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }
}
