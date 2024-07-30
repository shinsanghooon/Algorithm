package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem67258 {


    public static void main(String[] args) {
        Problem67258 t = new Problem67258();

        String[] gems = {
            "DIA",
            "RUBY",
            "RUBY",
            "DIA",
            "DIA",
            "EMER",
            "SAPP",
            "DIA"
        };

        int[] result = t.solution(gems);
//        System.out.println("result = " + Arrays.toString(result));

    }

    private int[] solution(String[] gems) {

        Map<Integer, Integer> possibleMap = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < gems.length; i++) {
            Set gemSet = new HashSet<>(List.of(gems));
            for (int j = i; j < gems.length; j++) {
//                System.out.println("i + j = " + i + "/ " +j);
                String gem = gems[j];
                gemSet.remove(gem);

                if (gemSet.isEmpty()) {

                    if (j - i < min) {
                        min = j - i;
                        start = i + 1;
                        end = j + 1;
                    }

//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
//                    System.out.println("------");
                }
            }
        }

        return new int[]{start, end};
    }

    public int[] solution2(String[] gems) {
        int start = 0;
        int end = gems.length - 1;
        Set<String> gemSet = new HashSet<>(List.of(gems));

        int s = 0;
        int e = s;
        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[s], 1);

        while (s < gems.length) {

            // 구간 내 모든 보석이 포함된 경우
            if (includes.keySet().size() == gemSet.size()) {

                // 전체를 가질 때 구간 길이가 작은 경우 구간 업데이트
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }

                // s는 초기에 시작점 그대로 유지된 상태
                // 여기가 포인트인게 뭐냐면
                // s를 옮겨가면서 기존에 s 위치에 있던 보석만 제거하는 형태를 취함
                // 따라서 s가 옮겨간 후에도 그대로 includes된 보석을 확인할 수 있는 장점이 있음
                includes.put(gems[s], includes.get(gems[s]) - 1);
                if (includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            }
            // e를 올려가면서 보석을 하나씩 주워담음
            else if (e < gems.length - 1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return new int[]{start + 1, end + 1};

    }

}
