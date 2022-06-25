package algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class FlippedPrime {

    // 소수 만드는 로직 숙지하기
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        // 2부터 자기 자기 전까지 소수가 발견되면 소수가 아니다.
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();


        // 숫자 거꾸로 뒤집는 로직 숙지하기
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FlippedPrime T = new FlippedPrime();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ArrayList<Integer> answer = T.solution(n, arr);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
