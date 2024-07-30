package algorithm.programmerskit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Pccp1Heredity {

    public ArrayList<String[]> generations = new ArrayList<>();

    public static void main(String[] args) {
        Pccp1Heredity t = new Pccp1Heredity();

        int[][] queries = {{4, 26}};
//        int[][] queries = {{3, 1}, {2, 3}, {3, 9}};
        t.solution(queries);
    }

    public String[] solution(int[][] queries) {
//
//        for (int i = 0; i < 5; i++) {
//            createNthGeneration(i + 1);
//        }
//
//        for (String[] generation : generations) {
//            for (String s : generation) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }
//
//
//        String[] results = new String[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            System.out.println("queries[i][0] = " + queries[i][0]);
//            String[] nthGeneration = getNthGeneration(queries[i][0]);
//            for (String s : nthGeneration) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//            results[i] = nthGeneration[queries[i][1] - 1];
//            System.out.println("results[i] = " + results[i]);
//
//        }

        String[] results = Arrays.stream(queries)
                .map(query -> find(query[0], query[1] - 1))
                .toArray(String[]::new);

        return results;
    }

    public String[] getNthGeneration(int n) {
        return generations.get(n - 1);
    }

    public String[] createNthGeneration(int n) {

        if (n == 1) {
            String[] result = new String[]{"Rr"};
            generations.add(result);
            return result;
        }

        if (n == 2) {
            String[] result =  new String[]{"RR", "Rr", "Rr", "rr"};
            generations.add(result);
            return result;
        }

        int base = 4;
        String[] RRPart = new String[(int) Math.pow(base, n - 2)];
        Arrays.fill(RRPart, "RR");

        String[] RrPart = new String[(int) Math.pow(base, n - 2) * 2];
        String[] RrPartBase = {"RR", "Rr", "Rr", "rr"};
        for (int i = 0; i < RrPart.length; i++) {
            RrPart[i] = RrPartBase[i % RrPartBase.length];
        }

        String[] rrPart = new String[(int) Math.pow(base, n - 2)];
        Arrays.fill(rrPart, "rr");

        if (n == 3) {
            String[] result = Stream.concat(Stream.concat(Arrays.stream(RRPart), Arrays.stream(RrPart)), Arrays.stream(rrPart))
                    .toArray(String[]::new);
            generations.add(result);
            return result;
        }

        // n = 4 이상 일때
        String[] middlePart = Stream.concat(Arrays.stream(generations.get(n - 2)),
                        Arrays.stream(generations.get(n - 2)))
                .toArray(String[]::new);

        String[] result = Stream.concat(Stream.concat(Arrays.stream(RRPart), Arrays.stream(middlePart)), Arrays.stream(rrPart))
                .toArray(String[]::new);
        generations.add(result);
        return result;

    }

    private String find(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        int slice = (int) Math.pow(4, n - 2);
        int group = p / slice;

        if (group == 0) {
            return "RR";
        }

        if (group == 3) {
            return "rr";
        }

        return find(n - 1, p % slice);
    }
}