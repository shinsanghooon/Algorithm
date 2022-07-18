package algorithm.hashmap;

import java.util.*;

public class Sales {

    private int[] solution(int n, int k, int[] arr) {

        int[] answer = new int[k];

        for (int i = 0; i < n - k + 1; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = i; j < i + 4; j++) {
                set.add(arr[j]);
            }
            answer[i] = set.size();
        }

        return answer;
    }

    private ArrayList<Integer> solution2(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int lt = 0;
        int rt = k - 1;
        for (int i = 0; i < k - 1; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        map.put(arr[rt], map.getOrDefault(arr[rt], 0 ) + 1);
        answer.add(map.keySet().size());

        for (rt = k; rt < arr.length; rt++) {
            map.put(arr[lt], map.getOrDefault(arr[lt], 0 ) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            map.put(arr[rt], map.getOrDefault(arr[rt], 0 ) + 1);

            answer.add(map.keySet().size());
            lt++;

        }

        return answer;
    }

    private ArrayList<Integer> solution3(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.keySet().size());

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }





    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Sales T = new Sales();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int answer : T.solution2(n, k, arr)) {
            System.out.print(answer + " ");
        }
    }
}
