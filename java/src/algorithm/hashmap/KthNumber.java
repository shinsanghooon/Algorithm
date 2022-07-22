package algorithm.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class KthNumber {

    private int solution(int n, int k, int[] arr) {

        int answer = -1;
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list);
        Collections.reverse(list);

        System.out.println("list = " + list);

        int lt = 0;
        int rt = 1;

        int tmp_k = 0;
        int num = 0;

        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = rt + 1; j < list.size(); j++) {
                int tmp = list.get(lt) + list.get(rt) + list.get(j);

                if (tmp != num) {
                    tmp_k++;
                }
                num = tmp;

                System.out.println("lt = " + lt);
                System.out.println("rt = " + rt);
                System.out.println("j = " + j);
                System.out.println("num = " + num);
                System.out.println(tmp_k);

                System.out.println("--------------------");

                if (k == tmp_k) {
                    return num;
                }
            }
            lt++;
            rt++;
        }

        return answer;
    }

    private int solution2(int n, int k, int[] arr) {
        // TreeSet은 정렬 + 중복제거 기능이 있다.
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 기본적으로 내림차순

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (int x : Tset) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        KthNumber T = new KthNumber();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution2(n, k, arr));

    }
}
