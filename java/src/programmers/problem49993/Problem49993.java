package programmers.problem49993;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem49993 {

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skillTrees = {
            "BACDE",
            "CBADF",
            "AECB",
            "BDA"
        };

        Problem49993 t = new Problem49993();
        int solution = t.solution(skill, skillTrees);
        System.out.println("solution = " + solution);

    }

    private int solution(String skill, String[] skillTrees) {
        int answer = 0;

        List<String> collect = Arrays.stream(skillTrees)
            .map(s -> s.replaceAll("[^" + skill + "]", ""))
            .filter(skill::startsWith)
            .collect(Collectors.toList());

        return collect.size();

    }

}
