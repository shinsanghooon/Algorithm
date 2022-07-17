package algorithm.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    private String solution(String str1, String str2) {
        String answer = "YES";

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : map1.keySet()) {
            int integer1 = map1.get(c);
            int integer2 = map2.get(c);

            if (integer1 != integer2) {
                return "NO";
            }
        }

        return answer;
    }

    private String solution2(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x)==0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Anagram T = new Anagram();
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(T.solution2(str1, str2));
    }
}
