package algorithm.string;

import java.util.Scanner;

public class ConvertUpperToLower {

    public String solution(String str) {
        String answer = "";

        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer = answer + Character.toUpperCase(x);
            } else {
                answer = answer + Character.toLowerCase(x);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        ConvertUpperToLower T = new ConvertUpperToLower();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
