package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;


// 이게 왜 그리디 알고리즘 인가?
public class Problem42862 {

    public static void main(String[] args) {

        Problem42862 t = new Problem42862();

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int solution = t.solution(n, lost, reserve);

        System.out.println("solution = " + solution);

    }

    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> owns = Arrays.stream(lost)
            .boxed()
            .collect(Collectors.toSet());

        owns.retainAll(Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();

        for (int i : lost) {
            q.add(i);
        }

        int get = 0;

        // 여분이 있는 애들을 순회하면서
        for (int r : reserve) {
            if (owns.contains(r)) {
                // 얘는 빌려줄 수 없음
                continue;
            }

            // 체육복이 없는 애가 번호 차이가 1보다 작거나,
            // 여벌 체육복이 있었는데 도난 당해서 자기 체육복이 1개 있는 경우
            // 애는 대상에서 제외한다.
            while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }

            if (q.isEmpty()) {
                break;
            }

            // 빌려줘야하는 애들의 번호가 여벌 체육복이 있는 애 번호 +1 보다 작으면 빌려준다.
            // 위에서 r-1 보다 작은 경우는 날렸으므로
            // 번호의 선택지는 r+1, r, r-1 밖에 없다. 하지만 내가 r 이니까 r도 제외해서
            // r + 1, r - 1 둘 중 하나 인 경우, peek을 하는 것이다.
            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }

        // 전체 중 lost가 도난을 당했고, own는 여벌 여유가 있는 애들 + get은 빌린 애들 !
        return n - lost.length + owns.size() + get;
    }


}
