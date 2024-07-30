package programmers.problem64064;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem64064 {

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) {
                continue;
            }
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public long solution(String[] user_id, String[] banned_id) {

        // 제재 아이디 마스킹 처리와 가능한 아이디에 대한 2차원 배열
        String[][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace("*", "."))
            .map(banned -> Arrays.stream(user_id)
                .filter(id -> id.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);
        //        bans
        //        fr*d* -> s = frodo / s = fradi
        //        *rodo -> s = frodo / s = crodo
        //        ****** -> s = abc123 / s = frodoc
        //        ****** -> s = abc123 / s = frodoc

        // 가능한 제재 아이디 조합
        Set<Set<String>> banSet = new HashSet<>();

        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    public static void main(String[] args) {

        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};

        Problem64064 problem64064 = new Problem64064();
        long solution = problem64064.solution(user_id, banned_id);
        System.out.println("solution = " + solution);

    }

}
