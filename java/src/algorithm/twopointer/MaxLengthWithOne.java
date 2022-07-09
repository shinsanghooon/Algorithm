package algorithm.twopointer;

import java.util.Arrays;
import java.util.Scanner;

// 어렵군. 틀림
public class MaxLengthWithOne {

    public int solution(int n, int k, int[] arr) {

        for (int i = 0; i < k; i++) {
            int sum_cnt = 0;
            int changeIndex = 0;
            for (int j = 1; j < arr.length - 1; j++) {
                int lt = j - 1;
                int rt = j + 1;
                int l_cnt = 0;
                int r_cnt = 0;

                if (arr[j] == 0) {
                    while (lt >= 0) {
                        if (arr[lt--] == 1) {
                            l_cnt++;
                        } else {
                            break;
                        }
                    }

                    while (rt < arr.length) {
                        if (arr[rt++] == 1) {
                            r_cnt++;
                        } else {
                            break;
                        }
                    }

                    System.out.println("j = " + j + " / l_cnt = " + l_cnt + " / " + "r_cnt = " + r_cnt);
                    if (sum_cnt < (l_cnt + r_cnt)) {
                        sum_cnt = l_cnt + r_cnt;
                        changeIndex = j;
                    }
                }
            }

            arr[changeIndex] = 1;


            for (int t = 0; t < arr.length; t++) {
                System.out.print(arr[t] + " ");
            }
            System.out.println();
            System.out.println("--------------------------------------");
        }


        int maxAnswer = 0;
        int answer = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 1 && arr[i+1] == 1) {
                answer++;
            } else if (arr[i] == 1 && arr[i + 1] == 0) {
                if (maxAnswer < answer) {
                    maxAnswer = answer;
                }
                answer = 1;
            }
        }

        return maxAnswer;
    }

    public int solution2(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt =  0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt ++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt --;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        MaxLengthWithOne T = new MaxLengthWithOne();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution2(n, k, arr));

    }
}
