package algorithm.programmerskit;

import java.util.Stack;

public class TargetNumber {

    private static class State {
        public final int index;
        public final int acc;

        public State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }


    public int solution2(int[] numbers, int target) {
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));

        int count = 0;

        while (!s.isEmpty()) {
            State state = s.pop();

            if (state.index == numbers.length) {
                if (state.acc == target) {
                    count++;
                }
                continue;
            }

            s.push(new State(state.index + 1, state.acc + numbers[state.index]));
            s.push(new State(state.index + 1, state.acc - numbers[state.index]));

        }
        return count;
    }

    static int target = 4;
    public static void main(String[] args) {
        TargetNumber t = new TargetNumber();

        int[] numbers = {4, 1, 2, 1};

        int dfs = t.DFS(0, 0, numbers);
        System.out.println("dfs = " + dfs);

        int i = t.solution2(numbers, target);
        System.out.println("answer = " + i);
    }

    private int DFS(int L, int now, int[] numbers) {
        if (L > numbers.length - 1) {
            // 깊이를 초과하면 종료해야함

            if (now == target) {
                // 마지막 값이 타겟값과 동일하면 카운트 해야하므로 1을 리턴
                return 1;
            }
        } else {
            // 전체 트리에 대한 값을 취합한다.
            return DFS(L + 1, now + numbers[L], numbers) + DFS(L + 1, now - numbers[L], numbers);
        }
        return 0;
    }
}
