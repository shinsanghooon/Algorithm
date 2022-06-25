package algorithm.string;

import java.util.Scanner;

public class CompressString {

    public String solution(String str) {

        char[] chars = str.toCharArray();
        String result = "";

        int repeatNumber = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                repeatNumber++;
            } else {
                if (repeatNumber == 1) {
                    result = result + chars[i-1];
                } else {
                    result = result + chars[i-1] + repeatNumber;
                }
                repeatNumber = 1;
            }

            // 끝에 빈 문자열을 추가해주면 이 코드가 필요 없어짐
            if (i == chars.length - 1) {
                if (repeatNumber == 1) {
                    result = result + chars[i];
                } else {
                    result = result + chars[i] + repeatNumber;
                }
            }
        }

        return result;
    }

    public String solution2(String s) {
        String answer = "";

        s = s + " ";

        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CompressString T = new CompressString();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println(T.solution2(str));
    }
}
