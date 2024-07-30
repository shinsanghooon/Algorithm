package algorithm.programmerskit;

import java.util.Arrays;

public class SkillTree {

    public static void main(String[] args) {

        SkillTree t = new SkillTree();

        String skill = "CBD";
        String[] skill_tress = {
                "BACDE",
                "CBADF",
                "AECB",
                "BDA"
        };

        int result = t.solution(skill, skill_tress);
        System.out.println("result = " + result);
    }

    private int solution(String skill, String[] skillTress) {

//        BCD
//        CBD
//        CB
//        BD
        Arrays.stream(skillTress)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .forEach(System.out::println);


        return (int) Arrays.stream(skillTress)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(s -> skill.contains(s) && s.startsWith(Character.toString(skill.charAt(0))))
                .count();

    }


}
