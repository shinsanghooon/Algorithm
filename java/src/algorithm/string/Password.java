package algorithm.string;

import java.util.Scanner;

public class Password {

    public String solution(String str, int numberOfCharacter) {

        String result = "";

        for (int i = 0; i < numberOfCharacter; i++) {
            char[] chars = str.substring(i * 7, (i + 1) * 7).toCharArray();

            double number = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    number = number + Math.pow(2, chars.length - j - 1);
                }
            }
            result = result + (char) number;
        }
        return result.toUpperCase();
    }

    public String solution2(String str, int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            System.out.println("tmp = " + tmp);
            System.out.println("num = " + num);

            answer += (char) num;
            str = str.substring(7);
        }

        return answer;
    }


    public static void main(String[] args) {
        Password T = new Password();
        Scanner scanner = new Scanner(System.in);
        int numberOfCharacter = scanner.nextInt();
        String str = scanner.next();
        System.out.println(T.solution2(str, numberOfCharacter));
    }
}
