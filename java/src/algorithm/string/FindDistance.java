package algorithm.string;

import java.util.Scanner;

public class FindDistance {

    public int[] solution(String word, String s) {

        char[] chars = word.toCharArray();
        char c = s.charAt(0);
        int[] distanceArr = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int minDistance = chars.length; // 1000이라고 해도 됨
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) {
                    int distance = Math.abs(i - j);
                    if (distance < minDistance) {
                        minDistance = distance;
                    }
                }
            }
            distanceArr[i] = minDistance;
        }

        return distanceArr;
    }

    public static void main(String[] args) {
        FindDistance T = new FindDistance();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");

        int[] solution = T.solution(s[0], s[1]);

        for(int distance: solution) {
            System.out.print(distance + " ");
        }
    }
}
