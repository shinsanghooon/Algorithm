package algorithm.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class AllAnagram {

    private int solution(String str1, String str2) {
        int answer = 0;

        int lt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        char[] targetStr = str1.toCharArray();
        char[] anagramStr = str2.toCharArray();

        for (char c : anagramStr) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < str2.length() - 1; i ++){
            map.put(targetStr[i], map.getOrDefault(targetStr[i], 0) + 1);
        }

        for (int rt = str2.length() - 1; rt < targetStr.length; rt++) {
            map.put(targetStr[rt], map.getOrDefault(targetStr[rt], 0) + 1);

            // 비교를 하고
            // map은 이렇게하면 두 개 비교가 된다.
            if (map2.equals(map)) {
                answer++;
            }

            map.put(targetStr[lt], map.get(targetStr[lt]) - 1);
            if (map.get(targetStr[lt]) == 0) {
                map.remove(targetStr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AllAnagram T = new AllAnagram();
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(T.solution(str1, str2));
    }
}
