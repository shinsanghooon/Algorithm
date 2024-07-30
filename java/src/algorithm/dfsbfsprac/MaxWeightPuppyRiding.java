package algorithm.dfsbfsprac;

public class MaxWeightPuppyRiding {

    private static int target, n, answer = 0;

    public static void main(String[] args) {

        MaxWeightPuppyRiding t = new MaxWeightPuppyRiding();

        target = 259;
        n = 5;
        int arr[] = {81, 58, 42, 33, 61};

        t.solution(target, n, arr);

        System.out.println("answer = " + answer);

    }

    private void solution(int target, int n, int[] arr) {
        DFS(0, 0, arr);
    }

    private void DFS(int startState, int weightSum, int[] dogWeight) {

        if (weightSum > target) {
            return;
        }

        // 더 이상 탐색 불가 
        if (startState == n) {
            answer = Math.max(answer, weightSum);
        } else {
            DFS(startState + 1, weightSum + dogWeight[startState], dogWeight);
            DFS(startState + 1, weightSum, dogWeight);
        }
    }

}
