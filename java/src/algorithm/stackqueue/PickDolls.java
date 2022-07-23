package algorithm.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class PickDolls {

    private int solution(int n, int[][] arr, int k, int[] pickArr) {

        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][pickArr[i] - 1] != 0) {
                    int dollNum = arr[j][pickArr[i] - 1];

                    if (stack.isEmpty()) {
                        stack.push(dollNum);
                    } else {
                        Integer beforeDollNum = stack.pop();
                        if (dollNum != beforeDollNum) {
                            stack.push(beforeDollNum);
                            stack.push(dollNum);
                        } else {
                            // 동일 인형일 때
                            answer += 2;
                        }
                    }
                    arr[j][pickArr[i] - 1] = 0;
                    break;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {

        PickDolls T = new PickDolls();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dolls = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dolls[i][j] = scanner.nextInt();
            }
        }

        int pickNum = scanner.nextInt();
        int[] pickArr = new int[pickNum];
        for (int k = 0; k < pickNum; k++) {
            pickArr[k] = scanner.nextInt();
        }

        System.out.println(T.solution(n, dolls, pickNum, pickArr));
    }
}
