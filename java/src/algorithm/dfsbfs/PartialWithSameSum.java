package algorithm.dfsbfs;

public class PartialWithSameSum {


    private static int[] ch;
    private static String answer = "NO";

    private static int n;

    private static int target = 0;

    public static void main(String[] args) {
        PartialWithSameSum t = new PartialWithSameSum();

        n = 6;
        int[] arr = {1, 3, 5, 6, 7, 10};

        t.solution(arr);

        System.out.println("answer = " + answer);

    }

    private void solution(int[] arr) {

        int total = 0;
        for (int i : arr) {
            total += i;
        }
        target = total / 2;

        DFS(0, 0, arr);

    }

    private void DFS(int index, int sum, int[] arr) {

        if (index >= n) {
            return;
        }

        if (sum == target) {
            answer = "YES";
            return;
        }

        DFS(index + 1, sum + arr[index], arr);
        DFS(index + 1, sum, arr);

    }

}
