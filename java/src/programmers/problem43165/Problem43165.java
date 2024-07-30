package programmers.problem43165;


import java.util.Stack;

public class Problem43165 {

    public static void main(String[] args) {
        Problem43165 t = new Problem43165();

        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        int result = t.solution(numbers, target);
        System.out.println("result = " + result);
    }

    private int solution(int[] numbers, int target) {
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

            s.push(new State(state.index + 1, state.acc - numbers[state.index]));
            s.push(new State(state.index + 1, state.acc + numbers[state.index]));
        }

        return count;
    }

}


class State {
    public final int index;
    public final int acc;

    public State(int index, int acc) {
        this.index = index;
        this.acc = acc;
    }
}
