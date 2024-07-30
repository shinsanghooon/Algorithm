package algorithm.programmerskit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pccp1LonelyAlphabet {
    public static void main(String[] args) {
        Pccp1LonelyAlphabet t = new Pccp1LonelyAlphabet();

        String s = "zbzbz";

        String answer = t.solution(s);
        System.out.println("answer = " + answer);

    }

    private String solution(String s) {

        ArrayList<Character> result = new ArrayList<>();

        Set<Character> characterSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            characterSet.add(c);
        }

        for (Character target : characterSet) {
            int[] array = IntStream.range(0, s.length())
                    .filter(i -> s.charAt(i) == target)
                    .toArray();

            for (int i = 0; i < array.length - 1; i++) {
                int gap = array[i + 1] - array[i];
                if (gap != 1) {
                    result.add(target);
                }
            }
        }

        if (result.isEmpty()) {
            return "N";
        }

        return result.stream()
                .distinct()
                .sorted()
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());
    }


}
