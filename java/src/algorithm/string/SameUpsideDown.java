package algorithm.string;

import java.util.Scanner;

class SameUpsideDown {

    public String solution(String str) {

        String s = str.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverseStr = stringBuilder.reverse().toString();

        String answer;
        if (reverseStr.equals(s)) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SameUpsideDown T = new SameUpsideDown();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution2(str));

    }
}