package algorithm.string;

import java.util.Scanner;

public class RemoveDuplicateCharacter {

    public String solution(String str) {

        StringBuffer stringBuffer = new StringBuffer();

        for (char s : str.toCharArray()) {
            if (stringBuffer.indexOf(String.valueOf(s)) == -1) {
                stringBuffer.append(s);
            }
        }

        return stringBuffer.toString();
    }

    public String solution2(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        RemoveDuplicateCharacter T = new RemoveDuplicateCharacter();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution2(str));
    }
}
