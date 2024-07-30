package programmers.problem67257;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem67257 {

    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split(""),
    };

    private long calculate(long lhs, long rhs, String op) {
        long result;
        if (op.equals("+")) {
            result = lhs + rhs;
        } else if (op.equals("-")) {
            result = lhs - rhs;
        } else if (op.equals("*")) {
            result = lhs * rhs;
        } else {
            result = 0;
        }
        return result;
    }

    private long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long calculateResult = calculate(lhs, rhs, op);

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);

                    tokens.add(i - 1, String.valueOf(calculateResult));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        ArrayList<String> tokens = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem67257 problem67257 = new Problem67257();

//        Scanner sc = new Scanner(System.in);
//        String expression = sc.next();

        String expression = "100-200*300-500+20";
        long solution = problem67257.solution(expression);
        System.out.println("solution = " + solution);
    }
}
