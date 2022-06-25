package algorithm.string;

import java.util.Scanner;

public class FlipWord {

    public String solution(String word) {

        String flippedWord = "";

        for (int i = word.length()-1; i >= 0; i--) {
            flippedWord += word.charAt(i);
        }
        return flippedWord;
    }

    // StringBuilder 사용해서 해보기
    // StringBuilder.reverse().toString()
    // 왜 스트링이 있는데 스트링 빌더를 사용하는가?
    public String solution2(String word) {
        return new StringBuilder(word).reverse().toString();
    }


    public static void main(String[] args) {
        FlipWord T = new FlipWord();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = kb.next();
        }

        for (String word : strArr) {
            System.out.println(T.solution2(word));
        }
    }
}
