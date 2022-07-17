package algorithm.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Chairman {

    private char solution(int n, String str) {

        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
//            System.out.println(key);
//            System.out.println(map.get(key));

            if (max < map.get(key)) {
                answer = key;
                max = map.get(key);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Chairman T = new Chairman();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String str = scanner.next();

        System.out.println(T.solution(n, str));

    }
}
