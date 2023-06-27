package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Problem42576 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> countMap = new HashMap<>();
        for (String name : participant) {
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        for (String completedName : completion) {
            int v = countMap.get(completedName) - 1;
            countMap.put(completedName, v);
            if (v == 0) {
                countMap.remove(completedName);
            }
        }

        return countMap.keySet().iterator().next();
    }

    public static void main(String[] args) {
        Problem42576 t = new Problem42576();

        String[] participant = new String[]{"leo", "kiki", "eden", "kiki"};
        String[] completion = new String[]{"leo", "kiki", "kiki"};
        String solution = t.solution(participant, completion);
        System.out.println("solution = " + solution);

    }
}
