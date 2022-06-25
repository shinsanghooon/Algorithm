package algorithm.string;

import java.util.Scanner;

public class SameUpsideDownWithSpecialCharacter {

    public String solution(String str) {

        System.out.println("str = " + str);
        char[] chars = str.toLowerCase().toCharArray();

        String newStr = "";
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                newStr += String.valueOf(c);
            }
        }

        System.out.println("newStr = " + newStr);

        StringBuilder stringBuilder = new StringBuilder(newStr);
        String reverseStr = stringBuilder.reverse().toString();

        System.out.println("reverseStr = " + reverseStr);

        String answer;
        if (reverseStr.equals(newStr)) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");  // ^A-Z 알파벳이 아니면!
        System.out.println("str = " + str);

        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        SameUpsideDownWithSpecialCharacter T = new SameUpsideDownWithSpecialCharacter();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(T.solution2(str));

    }
}
