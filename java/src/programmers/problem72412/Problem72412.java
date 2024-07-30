package programmers.problem72412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Problem72412 {


    public int[] solution(String[] info, String[] query) {

        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];

        for (int i = 0; i < answer.length; i++) {
            /// 쿼리에 맞는 지원자 세기
            answer[i] = count(query[i], scoresMap);
        }

        return answer;

    }

    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // 전체가 작은 케이스
        if (scores.get(start) < score) {
            return scores.size();
        }

        return start;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");

        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) {
            return 0;
        }

        // 해당 키에 있는 점수 리스트
        List<Integer> scores = scoresMap.get(key);

        // 기준이 되는 점수
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scores);

    }


    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
//                System.out.println("key = " + key);

                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
//            System.out.println("----------------------------------");
        }

        for (List<Integer> value : scoresMap.values()) {
            Collections.sort(value);
        }
        for (String s : scoresMap.keySet()) {
            System.out.println("scoresMap = " + scoresMap.get(s));
        }

        return scoresMap;
    }


    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }
        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index +1, prefix + "-", tokens, action);
    }

    public static void main(String[] args) {
        Problem72412 t = new Problem72412();

        String[] info = new String[]{
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };

        String[] query = new String[]{
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };

        int[] solution = t.solution(info, query);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }


}
