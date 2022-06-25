package algorithm.string;

import java.util.Scanner;

public class WordInSentence {

    public String solution(String sentence) {
        String[] s = sentence.split(" ");

        int maxWordLength = 0;
        int maxWordIndex = 0;

        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if (s1.length() > maxWordLength) {
                maxWordLength = s1.length();
                maxWordIndex = i;
            }
        }

        return s[maxWordIndex];
    }

    public String solution2(String sentence) {
        String answer = "";
        int m = 0;
        int pos;
        while((pos=sentence.indexOf(" "))!=-1) {
            String tmp = sentence.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            sentence = sentence.substring(pos+1);
        }

        if (sentence.length() > m) {
            answer = sentence;
        }

        return answer;
    }

    public static void main(String[] args) {
        WordInSentence T = new WordInSentence();
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        System.out.println(T.solution2(sentence));
    }
}
