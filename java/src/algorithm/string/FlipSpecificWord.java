package algorithm.string;

import java.util.Scanner;

public class FlipSpecificWord {

    public String solution(String word) {

        char[] chars = word.toCharArray();

        int lt = 0;
        int rt = chars.length-1;

        while (lt < rt) {
            if (Character.isAlphabetic(chars[lt]) && Character.isAlphabetic(chars[rt])) {
                char ltWord = chars[lt];
                char rtWord = chars[rt];
                chars[lt] = rtWord;
                chars[rt] = ltWord;
            }
            lt++;
            rt--;
        }

        return String.copyValueOf(chars);
    }

    public String solution2(String str) {
        String answer;
        char[] chars = str.toCharArray();

        int lt = 0;
        int rt = chars.length-1;

        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char ltWord = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = ltWord;
                lt++;
                rt--;
            }
        }

        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        FlipSpecificWord T = new FlipSpecificWord();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution2(str));

    }
}
