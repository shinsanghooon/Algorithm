package programmers.problem12926;

import java.util.Scanner;

public class Problem12926 {

    public String solution(String s, int n) {
        String answer = "";

        char[] chars = s.toCharArray();

        char[] arr = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char a = chars[i];
            if (!Character.isAlphabetic(a)) {
                arr[i] = a;
            } else {
                int offset = Character.isUpperCase(a) ? 'A' : 'a';
                int position = a - offset;
                position = (position + n) % ('Z' - 'A' + 1);
                arr[i] = (char) (offset + position);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : arr) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Problem12926 T = new Problem12926();

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = sc.nextInt();

        String solution = T.solution(s, n);
        System.out.println(solution);

    }


}
